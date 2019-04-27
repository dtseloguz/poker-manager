package com.kamarou.pokershmoker.dao.repository;

import com.kamarou.pokershmoker.dao.entity.GeneralConfig;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralConfigRepository extends JpaRepository<GeneralConfig, String> {

  Optional<GeneralConfig> findGeneralConfigByTournamentId(String tournamentId);
}
