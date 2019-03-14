package com.kamarou.pokershmoker.dao.repository;

import com.kamarou.pokershmoker.dao.entity.Player;
import com.kamarou.pokershmoker.dao.entity.PlayerFilter;
import java.util.List;

public interface FilterPlayerRepository {
  List<Player> findPlayersByFilter(PlayerFilter playerFilter, int offset, int limit);
}
