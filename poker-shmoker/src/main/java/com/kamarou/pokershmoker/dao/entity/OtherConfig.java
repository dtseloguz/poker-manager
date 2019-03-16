package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "otherConfig")
@Proxy(lazy = false)
public class OtherConfig extends Game {

  @Column
  @Enumerated(value = EnumType.STRING)
  private GameConfigType gameConfigType;

  @Column
  private boolean configPresent;

  @OneToOne(mappedBy = "otherConfig", fetch = FetchType.LAZY)
  private Tournament tournament;

  public OtherConfig() {
  }

  public OtherConfig(GameConfigType gameConfigType, boolean configPresent) {
    this.gameConfigType = gameConfigType;
    this.configPresent = configPresent;
  }

  public OtherConfig(double commission, int chipsAmount,
      GameConfigType gameConfigType, boolean configPresent) {
    super(commission, chipsAmount);
    this.gameConfigType = gameConfigType;
    this.configPresent = configPresent;
  }

  public Tournament getTournament() {
    return tournament;
  }

  public void setTournament(Tournament tournament) {
    this.tournament = tournament;
  }

  public GameConfigType getGameConfigType() {
    return gameConfigType;
  }

  public boolean isConfigPresent() {
    return configPresent;
  }

  public void setConfigPresent(boolean configPresent) {
    this.configPresent = configPresent;
  }

  public void setGameConfigType(GameConfigType gameConfigType) {
    this.gameConfigType = gameConfigType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    OtherConfig that = (OtherConfig) o;
    return configPresent == that.configPresent &&
        gameConfigType == that.gameConfigType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), gameConfigType, configPresent);
  }

  @Override
  public String toString() {
    return "OtherConfig{" +
        "gameConfigType=" + gameConfigType +
        ", configPresent=" + configPresent +
        ", commission=" + commission +
        ", chipsAmount=" + chipsAmount +
        ", id='" + id + '\'' +
        '}';
  }

}
