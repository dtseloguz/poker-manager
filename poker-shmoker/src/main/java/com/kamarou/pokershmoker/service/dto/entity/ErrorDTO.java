package com.kamarou.pokershmoker.service.dto.entity;

import java.io.Serializable;
import java.util.Objects;

public class ErrorDTO implements Serializable {

  private String description;

  public ErrorDTO(String description) {
    this.description = description;
  }

  public ErrorDTO() {
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDTO errorDTO = (ErrorDTO) o;
    return Objects.equals(description, errorDTO.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description);
  }

  @Override
  public String toString() {
    return "ErrorDTO{" +
        "description='" + description + '\'' +
        '}';
  }
}
