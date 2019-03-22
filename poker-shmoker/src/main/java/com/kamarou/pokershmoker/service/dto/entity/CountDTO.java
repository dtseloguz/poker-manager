package com.kamarou.pokershmoker.service.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

public class CountDTO {

  private Long count;

  public CountDTO(Long count) {
    this.count = count;
  }

  public CountDTO() {
  }

  @ApiModelProperty(readOnly = true, hidden = true)
  @JsonProperty(access = Access.READ_ONLY)
  public Long getCount() {
    return count;
  }

  @JsonIgnore
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
