package com.kamarou.pokershmoker.service.dto.converter;

import com.kamarou.pokershmoker.dao.entity.OtherConfig;
import com.kamarou.pokershmoker.service.dto.Converter;
import com.kamarou.pokershmoker.service.dto.entity.OtherConfigDTO;
import org.springframework.stereotype.Component;

@Component
public class OtherConfigConverter implements Converter<OtherConfigDTO, OtherConfig> {

  @Override
  public OtherConfigDTO convertToDTO(OtherConfig entity) {
    return new OtherConfigDTO(entity.getId(), entity.getGameConfigType(), entity.getChipsAmount(),
        entity.getCommission(), entity.isConfigPresent());
  }

  @Override
  public OtherConfig convertToEntity(OtherConfigDTO configDTO) {
    return new OtherConfig(configDTO.getCommission(), configDTO.getChipsAmount(),
        configDTO.getGameConfigType(), configDTO.isConfigPresent());
  }
}
