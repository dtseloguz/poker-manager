package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.RoundService;
import com.kamarou.pokershmoker.service.dto.entity.RoundDTO;
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

@Api(description = "Метод для обработки раундов принадлежащих конкретному турниру. "
    + "Для связи раундов и турниров в пути запроса нужно указывать ID турнира")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/poker-shmoker/tournaments/{tournamentId}/rounds")
public class RoundController {

  private final RoundService roundService;

  @Autowired
  public RoundController(RoundService roundService) {
    this.roundService = roundService;
  }

  @ApiOperation(value = "Метод создания уровня или перерыва")
  @PostMapping
  public ResponseEntity<RoundDTO> saveRound(
      @ApiParam(value = "ID турнира") @PathVariable String tournamentId,
      @RequestBody RoundDTO roundDTO) {
    roundDTO.setTournamentID(tournamentId);
    return ResponseEntity.status(HttpStatus.CREATED).body(roundService.saveRound(roundDTO));
  }

  @ApiOperation(value = "Метод выборки стуктуры раундов турнира. Список уже отсортирован по позиции")
  @GetMapping
  public ResponseEntity<List<RoundDTO>> selectOrderByPositionRounds(@ApiParam(value = "ID турнира")
  @PathVariable String tournamentId) {
    return ResponseEntity.ok(roundService.selectRoundsOrderByPosition(tournamentId));
  }

  @ApiOperation(value = "Метод удаления раунды по номеру позиции")
  @DeleteMapping(value = "/{position}")
  public ResponseEntity deleteRoundByTournamentIdAndPosition(
      @ApiParam(value = "ID турнира") @PathVariable String tournamentId,
      @ApiParam(value = "Номер позиции. Внутренний ID") @PathVariable int position) {
    roundService.deleteRoundByTournamentIdAndPosition(tournamentId, position);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @ApiOperation(value = "Метод получения конкретного раунда")
  @GetMapping(value = "/{position}")
  public ResponseEntity<RoundDTO> selectRoundByTournamentIdAndPosition(
      @ApiParam(value = "ID турнира")
      @PathVariable String tournamentId,
      @ApiParam(value = "ID раунда") @PathVariable int position) {
    return ResponseEntity
        .ok(roundService.selectRoundByTournamentIdAndPosition(tournamentId, position));
  }

  @ApiOperation(value = "Метод обновления раунда")
  @PutMapping
  public ResponseEntity<RoundDTO> updateRound(
      @ApiParam(value = "ID турнира") @PathVariable String tournamentId,
      @RequestBody RoundDTO roundDTO) {
    roundDTO.setTournamentID(tournamentId);
    return ResponseEntity.ok(roundService.updateRound(roundDTO));
  }


}
