package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;
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
  private double buyIn;

  @OneToOne(mappedBy = "generalConfig", fetch = FetchType.LAZY)
  private Tournament tournament;

  public GeneralConfig() {
  }

  public GeneralConfig(double commission, int chipsAmount, double buyIn, Tournament tournament) {
    super(commission, chipsAmount);
    this.buyIn = buyIn;
    this.tournament = tournament;
  }


  public GeneralConfig(String tournamentName, String description, double buyIn,
      Tournament tournament) {
    this.buyIn = buyIn;
    this.tournament = tournament;
  }


  public Tournament getTournament() {
    return tournament;
  }

  public void setTournament(Tournament tournament) {
    this.tournament = tournament;
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
    return Double.compare(that.buyIn, buyIn) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), buyIn);
  }

  @Override
  public String toString() {
    return "GeneralConfig{" +
        ", buyIn=" + buyIn +
        ", commission=" + commission +
        ", chipsAmount=" + chipsAmount +
        ", id='" + id + '\'' +
        '}';
  }
}
