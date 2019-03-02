package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.GeneralConfigService;
import com.kamarou.pokershmoker.service.dto.entity.GeneralConfigDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/poker-shmoker/configs")
public class ConfigController {

  private final GeneralConfigService generalConfigService;

  @Autowired
  public ConfigController(GeneralConfigService generalConfigService) {
    this.generalConfigService = generalConfigService;
  }

  @PostMapping(value = "/general")
  public ResponseEntity<GeneralConfigDTO> saveGeneralConfig(
      @RequestBody GeneralConfigDTO generalConfigDTO) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(generalConfigService.saveGeneralConfig(generalConfigDTO));
  }

  @PutMapping(value = "/general")
  public ResponseEntity<GeneralConfigDTO> updateGeneralConfig(
      @RequestBody GeneralConfigDTO generalConfigDTO) {
    return ResponseEntity.ok()
        .body(generalConfigService.updateGeneralConfig(generalConfigDTO));
  }

  @GetMapping(value = "/general/{generalConfigID}")
  public ResponseEntity<GeneralConfigDTO> selectGeneralConfig(
      @PathVariable String generalConfigID) {
    return ResponseEntity.ok(generalConfigService.selectGeneralConfigById(generalConfigID));
  }

  @GetMapping(value = "/general")
  public ResponseEntity<List<GeneralConfigDTO>> selectAllGeneralConfig() {
    return ResponseEntity.ok(generalConfigService.selectAllConfigs());
  }

  @DeleteMapping(value = "/general/{generalConfigID}")
  public ResponseEntity<GeneralConfigDTO> deleteGeneralConfig(
      @PathVariable String generalConfigID) {
    generalConfigService.deleteGeneralConfig(generalConfigID);
    return ResponseEntity.ok().build();
  }
}
