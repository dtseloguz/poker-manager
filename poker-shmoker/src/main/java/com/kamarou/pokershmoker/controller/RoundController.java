package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.RoundService;
import com.kamarou.pokershmoker.service.dto.entity.RoundDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/poker-shmoker/tournaments/{tournamentId}/rounds")
public class RoundController {

  private final RoundService roundService;

  @Autowired
  public RoundController(RoundService roundService) {
    this.roundService = roundService;
  }

  @PostMapping
  public ResponseEntity<RoundDTO> saveRound(@PathVariable String tournamentId,
      @RequestBody RoundDTO roundDTO) {
    roundDTO.setTournamentID(tournamentId);
    return ResponseEntity.status(HttpStatus.CREATED).body(roundService.saveRound(roundDTO));
  }

  @GetMapping
  public ResponseEntity<List<RoundDTO>> selectOrderByPositionRounds(
      @PathVariable String tournamentId) {
    return ResponseEntity.ok(roundService.selectRoundsOrderByPosition(tournamentId));
  }

}
