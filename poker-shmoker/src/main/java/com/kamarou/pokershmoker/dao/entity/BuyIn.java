package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;


@Table(name = "buy_in")
@Entity
@Proxy(lazy = false)
public class BuyIn extends BaseEntity {

  @Column
  private String dateBuy;

  @Column
  private boolean isBuy;

  @OneToOne(mappedBy = "buyIn")
  private Player player;

  public BuyIn() {
  }

  public BuyIn(String dateBuy, boolean isBuy, Player player) {
    this.dateBuy = dateBuy;
    this.isBuy = isBuy;
    this.player = player;
  }

  public String getDateBuy() {
    return dateBuy;
  }

  public void setDateBuy(String dateBuy) {
    this.dateBuy = dateBuy;
  }

  public boolean isBuy() {
    return isBuy;
  }

  public void setBuy(boolean buy) {
    isBuy = buy;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
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
    BuyIn buyIn = (BuyIn) o;
    return isBuy == buyIn.isBuy &&
        Objects.equals(dateBuy, buyIn.dateBuy) &&
        Objects.equals(player, buyIn.player);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), dateBuy, isBuy, player);
  }

  @Override
  public String toString() {
    return "BuyIn{" +
        "dateBuy=" + dateBuy +
        ", isBuy=" + isBuy +
        ", id=" + id +
        '}';
  }
}
