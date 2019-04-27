package com.kamarou.pokershmoker.service;

import com.kamarou.pokershmoker.service.dto.entity.GeneralConfigDTO;
import java.util.List;

public interface GeneralConfigService {

  GeneralConfigDTO updateGeneralConfig(GeneralConfigDTO configDTO);

  GeneralConfigDTO selectGeneralConfigById(String tournamentId);
}
