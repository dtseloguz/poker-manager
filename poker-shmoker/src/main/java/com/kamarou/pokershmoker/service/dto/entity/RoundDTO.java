package com.kamarou.pokershmoker.service.dto.entity;

import com.kamarou.pokershmoker.dao.entity.GameName;
import com.kamarou.pokershmoker.dao.entity.GameType;
import com.kamarou.pokershmoker.dao.entity.RoundType;
import java.io.Serializable;
import java.util.Objects;

public class RoundDTO implements Serializable {

  private String id;
  private int position;
  private int number;
  private int duration;
  private int timeLeft;
  private boolean chipUp;
  private GameName gameName;
  private GameType gameType;
  private double smallBlind;
  private double bigBlind;
  private double ante;
  private RoundType roundType;
  private String tournamentID;

  public RoundDTO() {
  }

  public RoundDTO(String id, int position, int number, int duration, int timeLeft, boolean chipUp,
      GameName gameName, GameType gameType, double smallBlind, double bigBlind, double ante,
      RoundType roundType, String tournamentID) {
    this.id = id;
    this.position = position;
    this.number = number;
    this.duration = duration;
    this.timeLeft = timeLeft;
    this.chipUp = chipUp;
    this.gameName = gameName;
    this.gameType = gameType;
    this.smallBlind = smallBlind;
    this.bigBlind = bigBlind;
    this.ante = ante;
    this.roundType = roundType;
    this.tournamentID = tournamentID;
  }

  public String getTournamentID() {
    return tournamentID;
  }

  public void setTournamentID(String tournamentID) {
    this.tournamentID = tournamentID;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public int getTimeLeft() {
    return timeLeft;
  }

  public void setTimeLeft(int timeLeft) {
    this.timeLeft = timeLeft;
  }

  public boolean isChipUp() {
    return chipUp;
  }

  public void setChipUp(boolean chipUp) {
    this.chipUp = chipUp;
  }

  public GameName getGameName() {
    return gameName;
  }

  public void setGameName(GameName gameName) {
    this.gameName = gameName;
  }

  public GameType getGameType() {
    return gameType;
  }

  public void setGameType(GameType gameType) {
    this.gameType = gameType;
  }

  public double getSmallBlind() {
    return smallBlind;
  }

  public void setSmallBlind(double smallBlind) {
    this.smallBlind = smallBlind;
  }

  public double getBigBlind() {
    return bigBlind;
  }

  public void setBigBlind(double bigBlind) {
    this.bigBlind = bigBlind;
  }

  public double getAnte() {
    return ante;
  }

  public void setAnte(double ante) {
    this.ante = ante;
  }

  public RoundType getRoundType() {
    return roundType;
  }

  public void setRoundType(RoundType roundType) {
    this.roundType = roundType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoundDTO roundDTO = (RoundDTO) o;
    return position == roundDTO.position &&
        number == roundDTO.number &&
        duration == roundDTO.duration &&
        timeLeft == roundDTO.timeLeft &&
        chipUp == roundDTO.chipUp &&
        Double.compare(roundDTO.smallBlind, smallBlind) == 0 &&
        Double.compare(roundDTO.bigBlind, bigBlind) == 0 &&
        Double.compare(roundDTO.ante, ante) == 0 &&
        Objects.equals(id, roundDTO.id) &&
        gameName == roundDTO.gameName &&
        gameType == roundDTO.gameType &&
        roundType == roundDTO.roundType &&
        Objects.equals(tournamentID, roundDTO.tournamentID);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, position, number, duration, timeLeft, chipUp, gameName, gameType, smallBlind,
            bigBlind, ante, roundType, tournamentID);
  }

  @Override
  public String toString() {
    return "RoundDTO{" +
        "id='" + id + '\'' +
        ", position=" + position +
        ", number=" + number +
        ", duration=" + duration +
        ", timeLeft=" + timeLeft +
        ", chipUp=" + chipUp +
        ", gameName=" + gameName +
        ", gameType=" + gameType +
        ", smallBlind=" + smallBlind +
        ", bigBlind=" + bigBlind +
        ", ante=" + ante +
        ", roundType=" + roundType +
        ", tournamentID='" + tournamentID + '\'' +
        '}';
  }
}
