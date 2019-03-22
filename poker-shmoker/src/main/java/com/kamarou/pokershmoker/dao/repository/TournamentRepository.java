package com.kamarou.pokershmoker.dao.repository;

import com.kamarou.pokershmoker.dao.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, String> {

}
