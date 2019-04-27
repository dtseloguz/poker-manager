package com.kamarou.pokershmoker.dao.repository;

import com.kamarou.pokershmoker.dao.entity.Round;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RoundRepository extends JpaRepository<Round, String> {

  @Query(value = "select round.number from round where round_type = ?1 order by number desc limit 1",
      nativeQuery = true)
  Integer findLastRoundNumber(String roundType);

  @Query(value = "select r.* from round r where r.tournament_id = ?1 order by r.position", nativeQuery = true)
  List<Round> findRoundByOrderByPosition(String tournamentId);

  @Query(value = "select count(*) from round", nativeQuery = true)
  Integer findTotalRoundCount();

  Optional<Round> findRoundByTournamentIdAndPosition(String tournamentId, int position);

  @Modifying
  void deleteRoundByTournamentIdAndPosition(String tournamentId, int position);
}
