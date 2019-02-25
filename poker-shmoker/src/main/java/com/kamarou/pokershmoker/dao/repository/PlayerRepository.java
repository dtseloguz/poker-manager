package com.kamarou.pokershmoker.dao.repository;

import com.kamarou.pokershmoker.dao.entity.Player;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

  @Query(value = "select * from player p where p.buy_in_id in "
      + "(select buy_in.id from buy_in where is_buy = ?3) offset ?2 limit ?1 ", nativeQuery = true)
  List<Player> findPlayersByBuyInIsBuy(int limit, int offset, boolean isBuy);

  @Query(value = "select * from player p offset ?2 limit ?1", nativeQuery = true)
  List<Player> findPlayersByBorder(int limit, int offset);
}
