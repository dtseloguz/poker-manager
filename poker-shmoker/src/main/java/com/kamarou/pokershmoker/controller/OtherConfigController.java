package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.OtherConfigService;
import com.kamarou.pokershmoker.service.dto.entity.OtherConfigDTO;
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

@Api(description = "API для управления не общими конфигами турнира")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/poker-shmoker/tournament/{tournamentId}/configs/other")
public class OtherConfigController {

  private final OtherConfigService configService;

  @Autowired
  public OtherConfigController(OtherConfigService configService) {
    this.configService = configService;
  }

  @ApiOperation(value = "Метод обновления конфигов турнира")
  @PutMapping
  public ResponseEntity<OtherConfigDTO> updateGeneralConfig(
      @ApiParam(value = "ID турнира") @PathVariable String tournamentId,
      @RequestBody OtherConfigDTO otherConfigDTO) {
    otherConfigDTO.setTournamentID(tournamentId);
    return ResponseEntity.ok().body(configService.updateOtherConfig(otherConfigDTO));
  }

  @ApiOperation(value = "Метод получения неосновных конфигов турнира")
  @GetMapping
  public ResponseEntity<OtherConfigDTO> selectGeneralConfig(
      @ApiParam(value = "ID турнира") @PathVariable String tournamentId) {
    return ResponseEntity.ok(configService.selectOtherConfigById(tournamentId));
  }
}
