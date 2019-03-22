package com.kamarou.pokershmoker.dao.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
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

  public Tournament() {
  }

  public Tournament(GeneralConfig generalConfig,
      OtherConfig otherConfig, Set<Round> rounds) {
    this.generalConfig = generalConfig;
    this.otherConfig = otherConfig;
    this.rounds = rounds;
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
        Objects.equals(rounds, that.rounds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), generalConfig, otherConfig, rounds);
  }

  @Override
  public String toString() {
    return "Tournament{" +
        "generalConfig=" + generalConfig +
        ", otherConfig=" + otherConfig +
        ", rounds=" + rounds +
        ", id='" + id + '\'' +
        '}';
  }
}
