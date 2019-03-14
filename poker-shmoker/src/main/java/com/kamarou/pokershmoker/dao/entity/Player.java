package com.kamarou.pokershmoker.dao.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Table(name = "player")
@Entity
@Proxy(lazy = false)
public class Player extends BaseEntity {

  @Column(length = 50)
  private String name;

  @Column(length = 50)
  private String surname;

  @Column(length = 50)
  private String patronymic;

  @Column
  private short age;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "buy_in_id")
  private BuyIn buyIn;

  public Player() {
  }

  public Player(String name, String surname, String patronymic, short age) {
    this.name = name;
    this.surname = surname;
    this.patronymic = patronymic;
    this.age = age;
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

  public BuyIn getBuy() {
    return buyIn;
  }

  public void setBuy(BuyIn buys) {
    this.buyIn = buys;
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
    Player player = (Player) o;
    return age == player.age &&
        name.equals(player.name) &&
        surname.equals(player.surname) &&
        patronymic.equals(player.patronymic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name, surname, patronymic, age);
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", patronymic='" + patronymic + '\'' +
        ", age=" + age +
        ", buyIn=" + buyIn +
        ", id=" + id +
        '}';
  }

}
