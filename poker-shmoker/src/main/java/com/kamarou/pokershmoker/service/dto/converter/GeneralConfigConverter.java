package com.kamarou.pokershmoker.service.dto.converter;

import com.kamarou.pokershmoker.dao.entity.GeneralConfig;
import com.kamarou.pokershmoker.service.dto.Converter;
import com.kamarou.pokershmoker.service.dto.entity.GeneralConfigDTO;
import org.springframework.stereotype.Component;

@Component
public class GeneralConfigConverter implements Converter<GeneralConfigDTO, GeneralConfig> {
  @Override
  public GeneralConfigDTO convertToDTO(GeneralConfig config) {
    return new GeneralConfigDTO(config.getTournamentName(), config.getDescription(),
        config.getBuyIn(), config.getChipsAmount(), config.getCommission());
  }

  @Override
  public GeneralConfig convertToEntity(GeneralConfigDTO configDTO) {
    return new GeneralConfig(configDTO.getCommission(), configDTO.getChipsAmount(),
        configDTO.getTournamentName(), configDTO.getTournamentDescription(), configDTO.getBuyIn());
  }
}
