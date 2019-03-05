package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.TournamentService;
import com.kamarou.pokershmoker.service.dto.entity.TournamentDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/poker-shmoker/tournaments")
public class TournamentController {

  private final TournamentService tournamentService;

  @Autowired
  public TournamentController(TournamentService tournamentService) {
    this.tournamentService = tournamentService;
  }

  @PostMapping
  public ResponseEntity<TournamentDTO> saveTournament(@RequestBody TournamentDTO tournamentDTO) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(tournamentService.saveTournament(tournamentDTO));
  }

  @GetMapping(value = "/{tournamentId}")
  public ResponseEntity<TournamentDTO> selectTournament(
      @PathVariable(value = "tournamentId") String id) {
    return ResponseEntity.ok(tournamentService.selectTournamentById(id));
  }

  @GetMapping
  public ResponseEntity<List<TournamentDTO>> selectAllTournaments() {
    return ResponseEntity.ok(tournamentService.selectAllTournaments());
  }

  @DeleteMapping(value = "/{tournamentId}")
  public ResponseEntity deleteTournamentById(@PathVariable(value = "tournamentId") String id) {
    tournamentService.deleteTournamentById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
