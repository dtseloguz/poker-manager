package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table
@Proxy(lazy = false)
public class GeneralConfig extends Game {

  @Column
  private String tournamentName;

  @Column
  private String description;

  @Column
  private double buyIn;


  public GeneralConfig() {
  }

  public GeneralConfig(String tournamentName, String description, double buyIn) {
    this.tournamentName = tournamentName;
    this.description = description;
    this.buyIn = buyIn;
  }

  public GeneralConfig(double commission, int chipsAmount, String tournamentName,
      String description, double buyIn) {
    super(commission, chipsAmount);
    this.tournamentName = tournamentName;
    this.description = description;
    this.buyIn = buyIn;
  }


  public String getTournamentName() {
    return tournamentName;
  }

  public void setTournamentName(String tournamentName) {
    this.tournamentName = tournamentName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getBuyIn() {
    return buyIn;
  }

  public void setBuyIn(double buyIn) {
    this.buyIn = buyIn;
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
    GeneralConfig that = (GeneralConfig) o;
    return Double.compare(that.buyIn, buyIn) == 0 &&
        Objects.equals(tournamentName, that.tournamentName) &&
        Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), tournamentName, description, buyIn);
  }


  @Override
  public String toString() {
    return "GeneralConfig{" +
        "tournamentName='" + tournamentName + '\'' +
        ", description='" + description + '\'' +
        ", buyIn=" + buyIn +
        ", commission=" + commission +
        ", chipsAmount=" + chipsAmount +
        ", id='" + id + '\'' +
        '}';
  }
}
