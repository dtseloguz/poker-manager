//package com.kamarou.pokershmoker.dao.entity;
//
//import java.util.Objects;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.Table;
//import org.hibernate.annotations.Proxy;
//
//@Entity
//@Table
//@Proxy(lazy = false)
//public class Round extends BaseEntity {
//
//  @Column
//  protected int position;
//
//  @Column
//  protected int number;
//
//  @Column
//  protected int duration;
//
//  @Column(name = "time_left")
//  protected int timeLeft;
//
//  @Column(name = "chip_up")
//  private boolean chipUp;
//
//  @Column(name = "game_name")
//  @Enumerated(value = EnumType.STRING)
//  private GameName gameName;
//
//  @Column(name = "game_type")
//  @Enumerated(value = EnumType.STRING)
//  private GameType gameType;
//
//  @Column(name = "small_blind")
//  private double smallBlind;
//
//  @Column(name = "big_blind")
//  private double bigBlind;
//
//  @Column
//  private double ante;
//
//  @Column
//  @Enumerated(value = EnumType.STRING)
//  private RoundType roundType;
//
//  @Column
//  private Tournament tournament;
//
//  public Round() {
//  }
//
//  public Round(int position, int number, int duration, int timeLeft, boolean chipUp,
//      GameName gameName, GameType gameType, double smallBlind, double bigBlind, double ante,
//      RoundType roundType) {
//    this.position = position;
//    this.number = number;
//    this.duration = duration;
//    this.timeLeft = timeLeft;
//    this.chipUp = chipUp;
//    this.gameName = gameName;
//    this.gameType = gameType;
//    this.smallBlind = smallBlind;
//    this.bigBlind = bigBlind;
//    this.ante = ante;
//    this.roundType = roundType;
//  }
//
//  public int getPosition() {
//    return position;
//  }
//
//  public void setPosition(int position) {
//    this.position = position;
//  }
//
//  public int getNumber() {
//    return number;
//  }
//
//  public void setNumber(int number) {
//    this.number = number;
//  }
//
//  public int getDuration() {
//    return duration;
//  }
//
//  public void setDuration(int duration) {
//    this.duration = duration;
//  }
//
//  public int getTimeLeft() {
//    return timeLeft;
//  }
//
//  public void setTimeLeft(int timeLeft) {
//    this.timeLeft = timeLeft;
//  }
//
//  public boolean isChipUp() {
//    return chipUp;
//  }
//
//  public void setChipUp(boolean chipUp) {
//    this.chipUp = chipUp;
//  }
//
//  public GameName getGameName() {
//    return gameName;
//  }
//
//  public void setGameName(GameName gameName) {
//    this.gameName = gameName;
//  }
//
//  public GameType getGameType() {
//    return gameType;
//  }
//
//  public void setGameType(GameType gameType) {
//    this.gameType = gameType;
//  }
//
//  public double getSmallBlind() {
//    return smallBlind;
//  }
//
//  public void setSmallBlind(double smallBlind) {
//    this.smallBlind = smallBlind;
//  }
//
//  public double getBigBlind() {
//    return bigBlind;
//  }
//
//  public void setBigBlind(double bigBlind) {
//    this.bigBlind = bigBlind;
//  }
//
//  public double getAnte() {
//    return ante;
//  }
//
//  public void setAnte(double ante) {
//    this.ante = ante;
//  }
//
//  public RoundType getRoundType() {
//    return roundType;
//  }
//
//  public void setRoundType(RoundType roundType) {
//    this.roundType = roundType;
//  }
//
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    if (!super.equals(o)) {
//      return false;
//    }
//    Round round = (Round) o;
//    return position == round.position &&
//        number == round.number &&
//        duration == round.duration &&
//        timeLeft == round.timeLeft &&
//        chipUp == round.chipUp &&
//        Double.compare(round.smallBlind, smallBlind) == 0 &&
//        Double.compare(round.bigBlind, bigBlind) == 0 &&
//        Double.compare(round.ante, ante) == 0 &&
//        gameName == round.gameName &&
//        gameType == round.gameType &&
//        roundType == round.roundType;
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects
//        .hash(super.hashCode(), position, number, duration, timeLeft, chipUp, gameName, gameType,
//            smallBlind, bigBlind, ante, roundType);
//  }
//
//  @Override
//  public String toString() {
//    return "Round{" +
//        "position=" + position +
//        ", number=" + number +
//        ", duration=" + duration +
//        ", timeLeft=" + timeLeft +
//        ", chipUp=" + chipUp +
//        ", gameName=" + gameName +
//        ", gameType=" + gameType +
//        ", smallBlind=" + smallBlind +
//        ", bigBlind=" + bigBlind +
//        ", ante=" + ante +
//        ", roundType=" + roundType +
//        ", id='" + id + '\'' +
//        '}';
//  }
//}
