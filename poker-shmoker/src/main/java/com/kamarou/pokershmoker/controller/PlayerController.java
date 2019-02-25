package com.kamarou.pokershmoker.controller;

import com.kamarou.pokershmoker.service.PlayerService;
import com.kamarou.pokershmoker.service.dto.entity.PlayerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.UUID;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "API для страницы с базой данных игроков")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/poker-shmoker/database/players")
public class PlayerController {

  private final PlayerService playerService;

  @Autowired
  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @ApiOperation(value = "Метод для добавления игрока в базу данных")
  @PostMapping
  public ResponseEntity<PlayerDTO> savePlayer(@RequestBody PlayerDTO playerDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(playerService.savePlayer(playerDTO));
  }

  @ApiOperation(value = "Метод для получения игрока из базы данных по ID")
  @GetMapping(value = "/{uuid}")
  public ResponseEntity<PlayerDTO> selectPlayerById(@PathVariable UUID uuid) {
    return ResponseEntity.ok(playerService.selectPlayerById(uuid));
  }

  @ApiOperation(value = "Метод для обновления данных об игроке")
  @PutMapping
  public ResponseEntity<PlayerDTO> updatePlayer(@RequestBody PlayerDTO playerDTO) {
    return ResponseEntity.ok(playerService.updatePlayer(playerDTO));
  }

  @ApiOperation(value = "Метод для удаления игрока из базы данных")
  @DeleteMapping(value = "/{uuid}")
  public ResponseEntity deletePlayer(@PathVariable UUID uuid) {
    playerService.deletePlayer(uuid);
    return ResponseEntity.ok().build();
  }

  @ApiOperation(value = "Метод для получения игроков из базы данных с помощью фильтра",
      notes = "Обязательно задавать начальное и конечно значение для выборки.")
  @GetMapping
  public ResponseEntity<List<PlayerDTO>> selectAllPlayers(
      @ApiParam(value =
          "Параметр, с помощью которого можно выбрать список тех игроков, которые сделали Buy In или нет. "
              + "Если значение параметра уставить нулевым, то метод выберет всех игрогов")
      @RequestParam(name = "isBuy", required = false) Boolean isBuy,
      @ApiParam(value = "Номер начальной записи") @RequestParam(name = "start") int start,
      @ApiParam(value = "Номер конечной записи") @RequestParam(name = "end") int end) {
    List<PlayerDTO> playerDTOS;
    if (isBuy == null) {
      playerDTOS = playerService.selectAllPlayers(start, end);
    } else {
      playerDTOS = playerService.selectPlayersByIsBuy(start, end, isBuy);
    }
    return ResponseEntity.ok(playerDTOS);
  }


}
