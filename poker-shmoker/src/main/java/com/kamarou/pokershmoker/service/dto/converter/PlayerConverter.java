package com.kamarou.pokershmoker.service.dto.converter;

import com.kamarou.pokershmoker.dao.entity.BuyIn;
import com.kamarou.pokershmoker.dao.entity.Player;
import com.kamarou.pokershmoker.service.dto.Converter;
import com.kamarou.pokershmoker.service.dto.entity.BuyInDTO;
import com.kamarou.pokershmoker.service.dto.entity.PlayerDTO;
import org.springframework.stereotype.Component;


@Component
public class PlayerConverter implements Converter<PlayerDTO, Player> {

  @Override
  public PlayerDTO convertToDTO(Player player) {
    PlayerDTO playerDTO = new PlayerDTO(player.getId().toString(), player.getName(),
        player.getSurname(),
        player.getPatronymic(),
        player.getAge());
    playerDTO.setBuyInDTO(new BuyInDTO(player.getBuy().getId().toString(),
        player.getBuy().getDateBuy(),
        player.getBuy().isBuy()));
    return playerDTO;
  }

  @Override
  public Player convertToEntity(PlayerDTO playerDTO) {
    Player player = new Player(playerDTO.getName(), playerDTO.getSurname(),
        playerDTO.getPatronymic(),
        playerDTO.getAge());
    player.setBuy(
        new BuyIn(playerDTO.getBuyInDTO().getDate(), playerDTO.getBuyInDTO().isBuy(), player));
    return player;
  }
}
