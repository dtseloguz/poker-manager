package com.kamarou.pokershmoker.service.dto.entity;

import java.io.Serializable;
import java.util.Objects;

public class PlayerDTO implements Serializable {

  private String id;
  private String name;
  private String surname;
  private String patronymic;
  private short age;
  private BuyInDTO buyInDTO;

  public PlayerDTO(String id, String name, String surname, String patronymic, short age,
      BuyInDTO buyInDTO) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.patronymic = patronymic;
    this.age = age;
    this.buyInDTO = buyInDTO;
  }

  public PlayerDTO(String id, String name, String surname, String patronymic, short age) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.patronymic = patronymic;
    this.age = age;
  }

  public PlayerDTO(String name, String surname, String patronymic, short age,
      BuyInDTO buyInDTO) {
    this.name = name;
    this.surname = surname;
    this.patronymic = patronymic;
    this.age = age;
    this.buyInDTO = buyInDTO;
  }

  public PlayerDTO() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public short getAge() {
    return age;
  }

  public void setAge(short age) {
    this.age = age;
  }

  public BuyInDTO getBuyInDTO() {
    return buyInDTO;
  }

  public void setBuyInDTO(BuyInDTO buyInDTO) {
    this.buyInDTO = buyInDTO;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerDTO playerDTO = (PlayerDTO) o;
    return age == playerDTO.age &&
        Objects.equals(name, playerDTO.name) &&
        Objects.equals(surname, playerDTO.surname) &&
        Objects.equals(patronymic, playerDTO.patronymic) &&
        Objects.equals(buyInDTO, playerDTO.buyInDTO);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, patronymic, age, buyInDTO);
  }

  @Override
  public String toString() {
    return "PlayerDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", patronymic='" + patronymic + '\'' +
        ", age=" + age +
        ", buyInDTO=" + buyInDTO +
        '}';
  }
}
