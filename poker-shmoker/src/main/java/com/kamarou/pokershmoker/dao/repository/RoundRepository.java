package com.kamarou.pokershmoker.dao.repository;

import com.kamarou.pokershmoker.dao.entity.Round;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<Round, String> {
  List<Round> findRoundByOrderByPosition();
}
