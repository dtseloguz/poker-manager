package com.kamarou.pokershmoker.service.dto.entity;

import java.util.Objects;

public class CountDTO {
  private Long count;

  public CountDTO(Long count) {
    this.count = count;
  }

  public CountDTO() {
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountDTO countDTO = (CountDTO) o;
    return Objects.equals(count, countDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count);
  }

  @Override
  public String toString() {
    return "CountDTO{" +
        "count=" + count +
        '}';
  }
}
