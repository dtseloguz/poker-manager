package com.kamarou.pokershmoker.service;

import com.kamarou.pokershmoker.dao.entity.PlayerFilter;
import com.kamarou.pokershmoker.service.dto.entity.PlayerDTO;
import java.util.List;

public interface PlayerService {

  PlayerDTO savePlayer(PlayerDTO playerDTO);

  PlayerDTO selectPlayerById(String id);

  PlayerDTO updatePlayer(PlayerDTO playerDTO);

  void deletePlayersById(List<String> uuids);

  List<PlayerDTO> selectPlayersByFilter(PlayerFilter playerFilter, int start, int end);
}
