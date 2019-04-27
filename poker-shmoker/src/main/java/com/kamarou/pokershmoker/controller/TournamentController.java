package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.TournamentService;
import com.kamarou.pokershmoker.service.dto.entity.TournamentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "API для управления турнирами. На этой странице реализовано доп API на случай,"
    + " если всё таки мы что-нибудь поменяем, но это вряд ли")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/poker-shmoker/tournaments")
public class TournamentController {

  private final TournamentService tournamentService;

  @Autowired
  public TournamentController(TournamentService tournamentService) {
    this.tournamentService = tournamentService;
  }

  @ApiOperation(value = "Метод для создания турнира. Надо прислать JSON. "
      + "Инициализацию начальными значениями можешь взять из сваггера")
  @PostMapping
  public ResponseEntity<TournamentDTO> saveTournament(@RequestBody TournamentDTO tournamentDTO) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(tournamentService.saveTournament(tournamentDTO));
  }

  @ApiOperation(value = "Метод обновления информации о турнире")
  @PutMapping(value = "/{tournamentId}")
  public ResponseEntity<TournamentDTO> updateTournament(@PathVariable String tournamentId,
      @RequestBody TournamentDTO tournamentDTO) {
    tournamentDTO.setId(tournamentId);
    return ResponseEntity.status(HttpStatus.OK)
        .body(tournamentService.updateTournament(tournamentDTO));
  }

  @ApiOperation(value = "Метод получения турнира")
  @GetMapping(value = "/{tournamentId}")
  public ResponseEntity<TournamentDTO> selectTournament(@ApiParam(value = "ID турнира")
  @PathVariable(value = "tournamentId") String id) {
    return ResponseEntity.ok(tournamentService.selectTournamentById(id));
  }

  @ApiOperation(value = "Метод получения всех турниров со всеми конфигами и раундами.")
  @GetMapping
  public ResponseEntity<List<TournamentDTO>> selectAllTournaments() {
    return ResponseEntity.ok(tournamentService.selectAllTournaments());
  }

  @ApiOperation(value = "Метож удаления турнира по ID")
  @DeleteMapping(value = "/{tournamentId}")
  public ResponseEntity deleteTournamentById(
      @ApiParam(value = "ID турнира") @PathVariable(value = "tournamentId") String id) {
    tournamentService.deleteTournamentById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
