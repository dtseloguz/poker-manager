package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.OtherConfigService;
import com.kamarou.pokershmoker.service.dto.entity.OtherConfigDTO;
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
@RequestMapping(value = "/poker-shmoker/configs/other")
public class OtherConfigController {

  private final OtherConfigService configService;

  @Autowired
  public OtherConfigController(OtherConfigService configService) {
    this.configService = configService;
  }

  @PostMapping
  public ResponseEntity<OtherConfigDTO> saveGeneralConfig(
      @RequestBody OtherConfigDTO OtherConfigDTO) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(configService.saveOtherConfig(OtherConfigDTO));
  }

  @PutMapping
  public ResponseEntity<OtherConfigDTO> updateGeneralConfig(
      @RequestBody OtherConfigDTO OtherConfigDTO) {
    return ResponseEntity.ok()
        .body(configService.updateOtherConfig(OtherConfigDTO));
  }

  @GetMapping(value = "/{generalConfigID}")
  public ResponseEntity<OtherConfigDTO> selectGeneralConfig(
      @PathVariable String generalConfigID) {
    return ResponseEntity.ok(configService.selectOtherConfigById(generalConfigID));
  }

  @GetMapping
  public ResponseEntity<List<OtherConfigDTO>> selectAllGeneralConfig() {
    return ResponseEntity.ok(configService.selectAllConfigs());
  }

  @DeleteMapping(value = "/{generalConfigID}")
  public ResponseEntity<OtherConfigDTO> deleteGeneralConfig(
      @PathVariable String generalConfigID) {
    configService.deleteOtherConfig(generalConfigID);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
