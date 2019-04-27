package com.kamarou.pokershmoker.service;

import com.kamarou.pokershmoker.service.dto.entity.OtherConfigDTO;
import java.util.List;

public interface OtherConfigService {

  OtherConfigDTO updateOtherConfig(OtherConfigDTO configDTO);

  OtherConfigDTO selectOtherConfigById(String tournamentId);
}
