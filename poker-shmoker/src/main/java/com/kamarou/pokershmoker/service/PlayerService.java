package com.kamarou.pokershmoker.service;

import com.kamarou.pokershmoker.service.dto.entity.PlayerDTO;
import java.util.List;
import java.util.UUID;

public interface PlayerService {

  PlayerDTO savePlayer(PlayerDTO playerDTO);

  List<PlayerDTO> selectAllPlayers(int start, int end);

  PlayerDTO selectPlayerById(UUID id);

  PlayerDTO updatePlayer(PlayerDTO playerDTO);

  void deletePlayer(UUID id);

  List<PlayerDTO> selectPlayersByIsBuy(int start, int end, boolean isBuy);

}
