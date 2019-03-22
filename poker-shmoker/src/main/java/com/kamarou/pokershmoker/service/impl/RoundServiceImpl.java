package com.kamarou.pokershmoker.service.impl;

import com.kamarou.pokershmoker.dao.entity.Round;
import com.kamarou.pokershmoker.dao.entity.Tournament;
import com.kamarou.pokershmoker.dao.repository.RoundRepository;
import com.kamarou.pokershmoker.dao.repository.TournamentRepository;
import com.kamarou.pokershmoker.service.RoundService;
import com.kamarou.pokershmoker.service.dto.converter.RoundConverter;
import com.kamarou.pokershmoker.service.dto.entity.RoundDTO;
import com.kamarou.pokershmoker.service.exception.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService {

  private final RoundRepository roundRepository;
  private final RoundConverter roundConverter;
  private final TournamentRepository tournamentRepository;
  private static final Logger LOG = LoggerFactory.getLogger(RoundServiceImpl.class);
  private static final String TOURNAMENT_NOT_FOUND = "Турнир не найден";
  private static final String ROUND_NOT_FOUND = "Раунд не найден";

  @Autowired
  public RoundServiceImpl(RoundRepository roundRepository, RoundConverter roundConverter,
      TournamentRepository tournamentRepository) {
    this.roundRepository = roundRepository;
    this.roundConverter = roundConverter;
    this.tournamentRepository = tournamentRepository;
  }

  private List<RoundDTO> convertRoundsToDtos(List<Round> rounds) {
    return rounds
        .stream()
        .map(roundConverter::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional
  @Override
  public RoundDTO saveRound(RoundDTO roundDTO) {
    Optional<Tournament> optionalTournament = tournamentRepository
        .findById(roundDTO.getTournamentID());
    if (!optionalTournament.isPresent()) {
      LOG.error("Tournament with ID {} not found.", roundDTO.getTournamentID());
      throw new NotFoundException(TOURNAMENT_NOT_FOUND);
    }
    Integer lastNumber = roundRepository.findLastRoundNumber(roundDTO.getRoundType().toString());
    Integer roundCount = roundRepository.findTotalRoundCount();
    if (lastNumber != null) {
      roundDTO.setPosition(roundCount + 1);
      roundDTO.setNumber(lastNumber + 1);
    } else {
      if (roundCount == 0) {
        roundDTO.setPosition(1);
        roundDTO.setNumber(1);
      } else {
        roundDTO.setPosition(roundCount + 1);
        roundDTO.setNumber(1);
      }
    }
    Round round = roundConverter.convertToEntity(roundDTO);
    Tournament tournament = optionalTournament.get();
    tournament.getRounds().add(round);
    round.setTournament(tournament);
    LOG.info("Save round {}", roundDTO);
    return roundConverter.convertToDTO(roundRepository.save(round));
  }

  @Transactional
  @Override
  public RoundDTO updateRound(RoundDTO roundDTO) {
    Optional<Round> optionalRound = roundRepository
        .findRoundByTournamentIdAndPosition(roundDTO.getTournamentID(), roundDTO.getPosition());
    if (!optionalRound.isPresent()) {
      LOG.error("Round not found");
      throw new NotFoundException(ROUND_NOT_FOUND);
    }
    Round round = optionalRound.get();
    roundDTO.setId(round.getId());
    round.setBigBlind(roundDTO.getBigBlind());
    round.setAnte(roundDTO.getAnte());
    round.setChipUp(roundDTO.isChipUp());
    round.setDuration(roundDTO.getDuration());
    round.setGameName(roundDTO.getGameName());
    round.setGameType(roundDTO.getGameType());
    round.setNumber(roundDTO.getNumber());
    round.setPosition(roundDTO.getPosition());
    round.setRoundType(roundDTO.getRoundType());
    round.setTimeLeft(roundDTO.getTimeLeft());
    round.setSmallBlind(roundDTO.getSmallBlind());
    LOG.info("Update round {}", roundDTO);
    return roundConverter
        .convertToDTO(roundRepository.save(round));
  }

  @Override
  public RoundDTO selectRoundByTournamentIdAndPosition(String tournamentId, int position) {
    LOG.info("Select round by tournament ID {} and position ID {}", tournamentId, position);
    Optional<Round> optionalRound = roundRepository
        .findRoundByTournamentIdAndPosition(tournamentId, position);
    if (!optionalRound.isPresent()) {
      LOG.error("Round not found");
      throw new NotFoundException(ROUND_NOT_FOUND);
    }
    return roundConverter.convertToDTO(optionalRound.get());
  }

  @Transactional
  @Override
  public void deleteRoundByTournamentIdAndPosition(String tournamentId, int position) {
    LOG.info("Delete round by tournament ID {} and position ID {}", tournamentId, position);
    Optional<Round> optionalRound = roundRepository
        .findRoundByTournamentIdAndPosition(tournamentId, position);
    if (!optionalRound.isPresent()) {
      LOG.error("Round not found");
      throw new NotFoundException(ROUND_NOT_FOUND);
    }
    roundRepository.deleteRoundByTournamentIdAndPosition(tournamentId, position);
  }

  @Override
  public List<RoundDTO> selectRoundsOrderByPosition(String tournamentId) {
    LOG.info("Select rounds for tournament with ID {}", tournamentId);
    if (!tournamentRepository.existsById(tournamentId)) {
      LOG.error("Tournament with ID {} not found.", tournamentId);
      throw new NotFoundException(TOURNAMENT_NOT_FOUND);
    }
    return convertRoundsToDtos(roundRepository.findRoundByOrderByPosition(tournamentId));
  }
}
