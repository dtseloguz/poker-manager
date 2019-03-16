package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Game extends BaseEntity {

  @Column
  protected double commission;

  @Column
  protected int chipsAmount;

  public Game(double commission, int chipsAmount) {
    this.commission = commission;
    this.chipsAmount = chipsAmount;
  }

  public Game() {
  }

  public double getCommission() {
    return commission;
  }

  public void setCommission(double commission) {
    this.commission = commission;
  }

  public int getChipsAmount() {
    return chipsAmount;
  }

  public void setChipsAmount(int chipsAmount) {
    this.chipsAmount = chipsAmount;
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
    Game game = (Game) o;
    return Double.compare(game.commission, commission) == 0 &&
        chipsAmount == game.chipsAmount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), commission, chipsAmount);
  }

  @Override
  public String toString() {
    return "Game{" +
        "commission=" + commission +
        ", chipsAmount=" + chipsAmount +
        ", id='" + id + '\'' +
        '}';
  }
}
