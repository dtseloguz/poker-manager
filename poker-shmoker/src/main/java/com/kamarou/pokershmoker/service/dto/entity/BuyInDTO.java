package com.kamarou.pokershmoker.service.dto.entity;

import java.io.Serializable;
import java.util.Objects;

public class BuyInDTO implements Serializable {

  private String id;
  private String date;
  private boolean isBuy;

  public BuyInDTO(String id, String date, boolean isBuy) {
    this.id = id;
    this.date = date;
    this.isBuy = isBuy;
  }

  public BuyInDTO(String date, boolean isBuy) {
    this.date = date;
    this.isBuy = isBuy;
  }

  public BuyInDTO() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public boolean isBuy() {
    return isBuy;
  }

  public void setBuy(boolean buy) {
    isBuy = buy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuyInDTO buyInDTO = (BuyInDTO) o;
    return isBuy == buyInDTO.isBuy &&
        Objects.equals(date, buyInDTO.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, isBuy);
  }

  @Override
  public String toString() {
    return "BuyInDTO{" +
        "id=" + id +
        ", date='" + date + '\'' +
        ", isBuy=" + isBuy +
        '}';
  }
}
