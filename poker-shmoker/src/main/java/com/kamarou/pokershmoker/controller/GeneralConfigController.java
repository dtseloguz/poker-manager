package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.GeneralConfigService;
import com.kamarou.pokershmoker.service.dto.entity.GeneralConfigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/poker-shmoker/tournament/{tournamentId}/configs/general")
public class GeneralConfigController {

  private final GeneralConfigService generalConfigService;

  @Autowired
  public GeneralConfigController(GeneralConfigService generalConfigService) {
    this.generalConfigService = generalConfigService;
  }

  @PutMapping
  public ResponseEntity<GeneralConfigDTO> updateGeneralConfig(@PathVariable String tournamentId,
      @RequestBody GeneralConfigDTO generalConfigDTO) {
    generalConfigDTO.setTournamentID(tournamentId);
    return ResponseEntity.ok().body(generalConfigService.updateGeneralConfig(generalConfigDTO));
  }

  @GetMapping
  public ResponseEntity<GeneralConfigDTO> selectGeneralConfig(@PathVariable String tournamentId) {
    return ResponseEntity.ok(generalConfigService.selectGeneralConfigById(tournamentId));
  }
}
