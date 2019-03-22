package com.kamarou.pokershmoker.dao.repository.impl;

import com.kamarou.pokershmoker.dao.entity.OperatorType;
import com.kamarou.pokershmoker.dao.entity.Player;
import com.kamarou.pokershmoker.dao.entity.PlayerFilter;
import com.kamarou.pokershmoker.dao.repository.FilterPlayerRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class FilterPlayerRepositoryImpl implements FilterPlayerRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Player> findPlayersByFilter(PlayerFilter playerFilter, int offset, int limit) {
    StringBuilder selectStr = new StringBuilder("select p.* from player p ");
    String limitStr = "offset ?2 limit ?1";
    OperatorType operatorType = playerFilter.getOperatorType();
    List<Player> players = null;
    switch (operatorType) {
      case LIKE: {
        selectStr.append("where p.name like ?5 or p.surname like ?4 or p.patronymic like ?3 ")
            .append(limitStr);
        String value = "%" + playerFilter.getValue() + "%";
        players = entityManager.createNativeQuery(selectStr.toString(), Player.class)
            .setParameter(1, limit)
            .setParameter(2, offset)
            .setParameter(3, value)
            .setParameter(4, value)
            .setParameter(5, value)
            .getResultList();
        break;
      }
      case EQUALS: {
        selectStr.append("join buy_in b on p.buy_in_id = b.id where b.is_buy = ?3 ")
            .append(limitStr);
        players = entityManager.createNativeQuery(selectStr.toString(), Player.class)
            .setParameter(1, limit)
            .setParameter(2, offset)
            .setParameter(3, "true".equals(playerFilter.getValue().toUpperCase()))
            .getResultList();
        break;
      }
      case NO_FILTER: {
        players = entityManager
            .createNativeQuery(selectStr.append(limitStr).toString(), Player.class)
            .setParameter(1, limit)
            .setParameter(2, offset)
            .getResultList();
        break;
      }
    }
    return players;
  }
}
