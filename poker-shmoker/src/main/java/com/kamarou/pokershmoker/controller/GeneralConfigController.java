package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.GeneralConfigService;
import com.kamarou.pokershmoker.service.dto.entity.GeneralConfigDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "API управления основными конфигами турнира")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/poker-shmoker/tournament/{tournamentId}/configs/general")
public class GeneralConfigController {

  private final GeneralConfigService generalConfigService;

  @Autowired
  public GeneralConfigController(GeneralConfigService generalConfigService) {
    this.generalConfigService = generalConfigService;
  }

  @ApiOperation(value = "Метод обновления основных конфигов турнира")
  @PutMapping
  public ResponseEntity<GeneralConfigDTO> updateGeneralConfig(
      @ApiParam(value = "ID турнира") @PathVariable String tournamentId,
      @RequestBody GeneralConfigDTO generalConfigDTO) {
    generalConfigDTO.setTournamentID(tournamentId);
    return ResponseEntity.ok().body(generalConfigService.updateGeneralConfig(generalConfigDTO));
  }

  @ApiOperation(value = "Метод получения конфигов для конкретного турнира")
  @GetMapping
  public ResponseEntity<GeneralConfigDTO> selectGeneralConfig(
      @ApiParam(value = "ID турнира") @PathVariable String tournamentId) {
    return ResponseEntity.ok(generalConfigService.selectGeneralConfigById(tournamentId));
  }
}
