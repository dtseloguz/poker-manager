package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;

public class PlayerFilter {
  private OperatorType operatorType;
  private String value;

  public PlayerFilter(OperatorType operatorType, String value) {
    this.operatorType = operatorType;
    this.value = value;
  }

  public PlayerFilter() {
  }

  public OperatorType getOperatorType() {
    return operatorType;
  }

  public void setOperatorType(OperatorType operatorType) {
    this.operatorType = operatorType;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerFilter that = (PlayerFilter) o;
    return operatorType == that.operatorType &&
        Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operatorType, value);
  }

  @Override
  public String toString() {
    return "PlayerFilter{" +
        "operatorType=" + operatorType +
        ", value='" + value + '\'' +
        '}';
  }
}
