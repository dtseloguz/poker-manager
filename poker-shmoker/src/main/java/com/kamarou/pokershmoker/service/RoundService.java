package com.kamarou.pokershmoker.service;

import com.kamarou.pokershmoker.service.dto.entity.RoundDTO;
import java.util.List;

public interface RoundService {

  RoundDTO saveRound(RoundDTO roundDTO);

  RoundDTO updateRound(RoundDTO roundDTO);

  RoundDTO selectRoundById(String id);

  void deleteRoundById(String id);

  List<RoundDTO> selectRoundSortedByPosition();
}
