package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected UUID id;

  public BaseEntity() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseEntity that = (BaseEntity) o;
    return id == that.id;
  }

  @Override
  public String toString() {
    return "BaseEntity{" +
        "id=" + id +
        '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
