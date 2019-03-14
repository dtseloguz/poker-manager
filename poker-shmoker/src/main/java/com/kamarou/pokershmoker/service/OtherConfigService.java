package com.kamarou.pokershmoker.service;

import com.kamarou.pokershmoker.service.dto.entity.OtherConfigDTO;
import java.util.List;

public interface OtherConfigService {

  OtherConfigDTO saveOtherConfig(OtherConfigDTO configDTO);

  OtherConfigDTO updateOtherConfig(OtherConfigDTO configDTO);

  OtherConfigDTO selectOtherConfigById(String id);

  void deleteOtherConfig(String id);

  List<OtherConfigDTO> selectAllConfigs();

}
