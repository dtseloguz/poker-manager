package com.kamarou.pokershmoker.dao.repository;

import com.kamarou.pokershmoker.dao.entity.OtherConfig;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherConfigRepository extends JpaRepository<OtherConfig, String> {

  Optional<OtherConfig> findOtherConfigByTournamentId(String tournamentId);
}
