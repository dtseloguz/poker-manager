package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "generalConfig")
@Proxy(lazy = false)
public class GeneralConfig extends Game {

  @Column
  private String tournamentName;

  @Column
  private String description;

  @Column
  private double buyIn;

  @OneToOne(mappedBy = "generalConfig", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Tournament tournament;

  public GeneralConfig() {
  }

  public GeneralConfig(double commission, int chipsAmount, String tournamentName,
      String description, double buyIn, Tournament tournament) {
    super(commission, chipsAmount);
    this.tournamentName = tournamentName;
    this.description = description;
    this.buyIn = buyIn;
    this.tournament = tournament;
  }


  public GeneralConfig(String tournamentName, String description, double buyIn,
      Tournament tournament) {
    this.tournamentName = tournamentName;
    this.description = description;
    this.buyIn = buyIn;
    this.tournament = tournament;
  }


  public Tournament getTournament() {
    return tournament;
  }

  public void setTournament(Tournament tournament) {
    this.tournament = tournament;
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
        Objects.equals(description, that.description) &&
        Objects.equals(tournament, that.tournament);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), tournamentName, description, buyIn, tournament);
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
