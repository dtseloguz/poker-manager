package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.OtherConfigService;
import com.kamarou.pokershmoker.service.dto.entity.OtherConfigDTO;
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
@RequestMapping(value = "/poker-shmoker/tournament/{tournamentId}/configs/other")
public class OtherConfigController {

  private final OtherConfigService configService;

  @Autowired
  public OtherConfigController(OtherConfigService configService) {
    this.configService = configService;
  }

  @PutMapping
  public ResponseEntity<OtherConfigDTO> updateGeneralConfig(@PathVariable String tournamentId,
      @RequestBody OtherConfigDTO otherConfigDTO) {
    otherConfigDTO.setTournamentID(tournamentId);
    return ResponseEntity.ok().body(configService.updateOtherConfig(otherConfigDTO));
  }

  @GetMapping
  public ResponseEntity<OtherConfigDTO> selectGeneralConfig(@PathVariable String tournamentId) {
    return ResponseEntity.ok(configService.selectOtherConfigById(tournamentId));
  }
}
