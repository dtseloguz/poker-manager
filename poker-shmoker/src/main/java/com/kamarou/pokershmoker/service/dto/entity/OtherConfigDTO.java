package com.kamarou.pokershmoker.service.dto.entity;

import com.kamarou.pokershmoker.dao.entity.GameConfigType;
import java.io.Serializable;
import java.util.Objects;

public class OtherConfigDTO implements Serializable {

  private String id;
  private GameConfigType gameConfigType;
  private int chipsAmount;
  private double commission;
  private boolean configPresent;
  private String tournamentID;

  public OtherConfigDTO() {
  }

  public OtherConfigDTO(String id, GameConfigType gameConfigType, int chipsAmount,
      double commission,
      boolean configPresent, String tournamentID) {
    this.id = id;
    this.gameConfigType = gameConfigType;
    this.chipsAmount = chipsAmount;
    this.commission = commission;
    this.configPresent = configPresent;
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

  public GameConfigType getGameConfigType() {
    return gameConfigType;
  }

  public void setGameConfigType(GameConfigType gameConfigType) {
    this.gameConfigType = gameConfigType;
  }

  public int getChipsAmount() {
    return chipsAmount;
  }

  public void setChipsAmount(int chipsAmount) {
    this.chipsAmount = chipsAmount;
  }

  public double getCommission() {
    return commission;
  }

  public void setCommission(double commission) {
    this.commission = commission;
  }

  public boolean isConfigPresent() {
    return configPresent;
  }

  public void setConfigPresent(boolean configPresent) {
    this.configPresent = configPresent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OtherConfigDTO that = (OtherConfigDTO) o;
    return chipsAmount == that.chipsAmount &&
        Double.compare(that.commission, commission) == 0 &&
        configPresent == that.configPresent &&
        Objects.equals(id, that.id) &&
        gameConfigType == that.gameConfigType &&
        Objects.equals(tournamentID, that.tournamentID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, gameConfigType, chipsAmount, commission, configPresent, tournamentID);
  }

  @Override
  public String toString() {
    return "OtherConfigDTO{" +
        "id='" + id + '\'' +
        ", gameConfigType=" + gameConfigType +
        ", chipsAmount=" + chipsAmount +
        ", commission=" + commission +
        ", configPresent=" + configPresent +
        ", tournamentID='" + tournamentID + '\'' +
        '}';
  }
}
