package com.kamarou.pokershmoker.service.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

public class BuyInDTO implements Serializable {

  private String id;
  private String date;
  private String endDate;
  private boolean isBuy;

  public BuyInDTO(String id, String date, String endDate, boolean isBuy) {
    this.id = id;
    this.date = date;
    this.endDate = endDate;
    this.isBuy = isBuy;
  }

  public BuyInDTO(String date, String endDate, boolean isBuy) {
    this.date = date;
    this.endDate = endDate;
    this.isBuy = isBuy;
  }

  public BuyInDTO() {
  }

  @ApiModelProperty(readOnly = true, hidden = true)
  @JsonProperty(access = Access.READ_ONLY)
  public String getId() {
    return id;
  }

  @JsonIgnore
  public void setId(String id) {
    this.id = id;
  }

  @ApiModelProperty(readOnly = true, hidden = true)
  @JsonProperty(access = Access.READ_ONLY)
  public String getDate() {
    return date;
  }

  @JsonIgnore
  public void setDate(String date) {
    this.date = date;
  }

  public boolean isBuy() {
    return isBuy;
  }

  public void setBuy(boolean buy) {
    isBuy = buy;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
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
        Objects.equals(id, buyInDTO.id) &&
        Objects.equals(date, buyInDTO.date) &&
        Objects.equals(endDate, buyInDTO.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, endDate, isBuy);
  }

  @Override
  public String toString() {
    return "BuyInDTO{" +
        "id='" + id + '\'' +
        ", date='" + date + '\'' +
        ", endDate='" + endDate + '\'' +
        ", isBuy=" + isBuy +
        '}';
  }
}
