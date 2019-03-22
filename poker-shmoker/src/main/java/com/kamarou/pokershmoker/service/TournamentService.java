package com.kamarou.pokershmoker.service;

import com.kamarou.pokershmoker.service.dto.entity.TournamentDTO;
import java.util.List;

public interface TournamentService {

  TournamentDTO saveTournament(TournamentDTO tournamentDTO);

  TournamentDTO selectTournamentById(String id);

  List<TournamentDTO> selectAllTournaments();

  void deleteTournamentById(String id);
}
