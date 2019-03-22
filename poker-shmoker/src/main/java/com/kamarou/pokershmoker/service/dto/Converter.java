package com.kamarou.pokershmoker.service.dto;

import com.kamarou.pokershmoker.dao.entity.BaseEntity;
import java.io.Serializable;

public interface Converter<DTO extends Serializable, Entity extends BaseEntity> {

  DTO convertToDTO(Entity entity);

  Entity convertToEntity(DTO dto);
}
