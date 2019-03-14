package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity {

  @Id
  @GenericGenerator(name = "my-uuid",
      strategy = "com.kamarou.pokershmoker.dao.generator.CustomUUIDGenerator")
  @GeneratedValue(generator = "my-uuid")
  protected String id;

  public BaseEntity() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
