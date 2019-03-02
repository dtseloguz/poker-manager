package com.kamarou.pokershmoker.service.dto.entity;

import com.kamarou.pokershmoker.dao.entity.GameConfigType;
import java.io.Serializable;
import java.util.Objects;

public class OtherConfigDTO implements Serializable {

  private GameConfigType gameConfigType;
  private int chipsAmount;
  private double commission;
  private boolean configPresent;

  public OtherConfigDTO() {
  }

  public OtherConfigDTO(GameConfigType gameConfigType, int chipsAmount, double commission,
      boolean configPresent) {
    this.gameConfigType = gameConfigType;
    this.chipsAmount = chipsAmount;
    this.commission = commission;
    this.configPresent = configPresent;
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
        gameConfigType == that.gameConfigType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(gameConfigType, chipsAmount, commission, configPresent);
  }

  @Override
  public String toString() {
    return "OtherConfigConverter{" +
        "gameConfigType=" + gameConfigType +
        ", chipsAmount=" + chipsAmount +
        ", commission=" + commission +
        ", configPresent=" + configPresent +
        '}';
  }
}
