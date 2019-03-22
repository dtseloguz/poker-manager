package com.kamarou.pokershmoker.service;

import com.kamarou.pokershmoker.service.dto.entity.RoundDTO;
import java.util.List;

public interface RoundService {

  RoundDTO saveRound(RoundDTO roundDTO);

  RoundDTO updateRound(RoundDTO roundDTO);

  RoundDTO selectRoundByTournamentIdAndPosition(String tournamentId, int position);

  void deleteRoundByTournamentIdAndPosition(String tournamentId, int position);

  List<RoundDTO> selectRoundsOrderByPosition(String tournamentId);
}
