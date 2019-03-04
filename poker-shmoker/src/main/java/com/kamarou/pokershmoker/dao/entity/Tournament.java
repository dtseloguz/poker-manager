package com.kamarou.pokershmoker.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Table
@Entity
@Proxy(lazy = false)
public class Tournament extends BaseEntity {

  @Column(name = "general_configuration")
  private GeneralConfig generalConfig;

  @Column(name = "other_configuration")
  private OtherConfig otherConfig;

  @Column(name = "rounds")
  @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Round> rounds = new HashSet<>();


}
