package com.kamarou.pokershmoker.service.imp;

import com.kamarou.pokershmoker.dao.entity.Player;
import com.kamarou.pokershmoker.dao.repository.PlayerRepository;
import com.kamarou.pokershmoker.service.PlayerService;
import com.kamarou.pokershmoker.service.dto.converter.PlayerConverter;
import com.kamarou.pokershmoker.service.dto.entity.PlayerDTO;
import com.kamarou.pokershmoker.service.exception.InternalServerException;
import com.kamarou.pokershmoker.service.exception.LogicException;
import com.kamarou.pokershmoker.service.exception.NotFoundException;
import com.kamarou.pokershmoker.service.exception.ValidationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

  private final PlayerRepository playerRepository;
  private static final Logger LOG = LoggerFactory.getLogger(PlayerServiceImpl.class);
  private final PlayerConverter playerConverter;
  private static final String NOT_VALID_NAME = " может содержать строчные и заглавные буквы, дефис и быть длинной до 60 символов";
  private static final String NOT_VALID_AGE = "Игрок должен быть старше 18 лет";
  private static final String NOT_FOUND_PLAYER = "Игрок с ID %s не найден";
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  private List<PlayerDTO> convertToList(Collection<Player> players) {
    return players.stream()
        .map(playerConverter::convertToDTO)
        .collect(Collectors.toList());
  }

  private Player updateBuyInStatus(Player player) {
    Date tempDate = new Date();
    try {
      Date endDate = new SimpleDateFormat(DATE_FORMAT).parse(player.getBuy().getEndDayBuy());
      tempDate.after(endDate);
    } catch (ParseException e) {
      LOG.error("Parse date exception: {}", e);
      throw new InternalServerException("Ошибка в парсинге формата даты");
    }
    return player;
  }

  private void validateName(String type, String name) {
    Pattern pattern = Pattern.compile("^([А-Я][а-я]{1,29})|([А-Я][а-я]{1,29}-[А-Я][а-я]{0,29})$");
    Matcher matcher = pattern.matcher(name);
    if (!matcher.matches()) {
      LOG.error("Not valid name: {}", name);
      throw new ValidationException(type + NOT_VALID_NAME);
    }
  }

  private void validateAge(short age) {
    if (age > 150 || age < 18) {
      LOG.error("Not valid age: {}", age);
      throw new ValidationException(NOT_VALID_AGE);
    }
  }

  private void validatePlayer(PlayerDTO playerDTO) {
    validateName("Имя", playerDTO.getName());
    validateName("Фамилия", playerDTO.getSurname());
    validateName("Отчество", playerDTO.getPatronymic());
    validateAge(playerDTO.getAge());
  }

  @Autowired
  public PlayerServiceImpl(PlayerRepository playerRepository,
      PlayerConverter playerConverter) {
    this.playerRepository = playerRepository;
    this.playerConverter = playerConverter;
  }

  @Override
  public PlayerDTO savePlayer(PlayerDTO playerDTO) {
    LOG.info("Validate player: {}", playerDTO);
    validatePlayer(playerDTO);
    Player player = playerConverter.convertToEntity(playerDTO);
    LOG.info("Save player");
    if (playerDTO.getBuyInDTO().isBuy()) {
      player.getBuy().setDateBuy(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }
    return playerConverter.convertToDTO(playerRepository.save(player));
  }

  @Override
  public List<PlayerDTO> selectAllPlayers(int start, int end) {
    int limit = end - start;
    if (limit < 0 || end < 0 || start < 0) {
      LOG.error("Invalid border values");
      throw new LogicException("Неверные границы выбора списка игроков");
    }
    return convertToList(playerRepository.findPlayersByBorder(limit + 1, start));
  }

  @Override
  public PlayerDTO selectPlayerById(UUID id) {
    LOG.debug("Find player with ID: {}", id);
    Optional<Player> optionalPlayer = playerRepository.findById(id);
    if (!optionalPlayer.isPresent()) {
      LOG.error("Player not found");
      throw new NotFoundException(String.format(NOT_FOUND_PLAYER, id));
    }
    return playerConverter.convertToDTO(optionalPlayer.get());
  }

  @Override
  public PlayerDTO updatePlayer(PlayerDTO playerDTO) {
    LOG.info("Validate player: {}", playerDTO);
    validatePlayer(playerDTO);
    Optional<Player> optionalPlayer = playerRepository.findById(UUID.fromString(playerDTO.getId()));
    if (!optionalPlayer.isPresent()) {
      LOG.error("Player not found");
      throw new NotFoundException(String.format(NOT_FOUND_PLAYER, playerDTO.getId()));
    }
    Player player = optionalPlayer.get();
    player.setName(playerDTO.getName());
    player.setSurname(playerDTO.getSurname());
    player.setPatronymic(playerDTO.getPatronymic());
    player.setAge(playerDTO.getAge());
    if (playerDTO.getBuyInDTO().isBuy() && !player.getBuy().isBuy()) {
      player.getBuy().setDateBuy(new SimpleDateFormat(DATE_FORMAT).format(new Date()));
      player.getBuy().setEndDayBuy(playerDTO.getBuyInDTO().getEndDate());
    }
    player.getBuy().setBuy(playerDTO.getBuyInDTO().isBuy());
    LOG.info("Update player: {}", player);
    return playerConverter.convertToDTO(playerRepository.save(player));
  }

  @Override
  public void deletePlayer(UUID id) {
    LOG.debug("Delete player with ID: {}", id);
    Optional<Player> optionalPlayer = playerRepository.findById(id);
    if (!optionalPlayer.isPresent()) {
      LOG.error("Player not found");
      throw new NotFoundException(String.format(NOT_FOUND_PLAYER, id));
    }
    playerRepository.deleteById(id);
  }

  @Override
  public List<PlayerDTO> selectPlayersByIsBuy(int start, int end, boolean isBuy) {
    int limit = end - start;
    if (limit < 0) {
      LOG.error("Invalid border values");
      throw new LogicException("Неверные границы выбора списка игроков");
    }
    LOG.info("Select players buy by isBuy equals: {}", isBuy);
    return convertToList(playerRepository.findPlayersByBuyInIsBuy(limit + 1, start, isBuy));
  }
}
