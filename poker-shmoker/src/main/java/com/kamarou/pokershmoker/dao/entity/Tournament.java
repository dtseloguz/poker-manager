package com.kamarou.pokershmoker.dao.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Table(name = "tournament")
@Entity
@Proxy(lazy = false)
public class Tournament extends BaseEntity {

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "gen_conf_id")
  private GeneralConfig generalConfig;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "other_conf_id")
  private OtherConfig otherConfig;

  @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Round> rounds = new HashSet<>();

  @Column
  private String tournamentName;

  @Column
  private String description;

  public Tournament() {
  }

  public Tournament(GeneralConfig generalConfig,
      OtherConfig otherConfig, Set<Round> rounds, String tournamentName, String description) {
    this.generalConfig = generalConfig;
    this.otherConfig = otherConfig;
    this.rounds = rounds;
    this.tournamentName = tournamentName;
    this.description = description;
  }

  public GeneralConfig getGeneralConfig() {
    return generalConfig;
  }

  public void setGeneralConfig(GeneralConfig generalConfig) {
    this.generalConfig = generalConfig;
  }

  public OtherConfig getOtherConfig() {
    return otherConfig;
  }

  public void setOtherConfig(OtherConfig otherConfig) {
    this.otherConfig = otherConfig;
  }

  public Set<Round> getRounds() {
    return rounds;
  }

  public void setRounds(Set<Round> rounds) {
    this.rounds = rounds;
  }

  public String getTournamentName() {
    return tournamentName;
  }

  public void setTournamentName(String tournamentName) {
    this.tournamentName = tournamentName;
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
    if (!super.equals(o)) {
      return false;
    }
    Tournament that = (Tournament) o;
    return Objects.equals(generalConfig, that.generalConfig) &&
        Objects.equals(otherConfig, that.otherConfig) &&
        Objects.equals(rounds, that.rounds) &&
        Objects.equals(tournamentName, that.tournamentName) &&
        Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), generalConfig, otherConfig, rounds, tournamentName, description);
  }

  @Override
  public String toString() {
    return "Tournament{" +
        "generalConfig=" + generalConfig +
        ", otherConfig=" + otherConfig +
        ", rounds=" + rounds +
        ", tournamentName='" + tournamentName + '\'' +
        ", description='" + description + '\'' +
        ", id='" + id + '\'' +
        '}';
  }
}
