package com.kamarou.pokershmoker.service.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TournamentDTO implements Serializable {

  private String id;
  private GeneralConfigDTO generalConfigDTO;
  private OtherConfigDTO otherConfigDTO;
  private List<RoundDTO> rounds;

  public TournamentDTO() {
  }

  public TournamentDTO(String id,
      GeneralConfigDTO generalConfigDTO,
      OtherConfigDTO otherConfigDTO,
      List<RoundDTO> rounds) {
    this.id = id;
    this.generalConfigDTO = generalConfigDTO;
    this.otherConfigDTO = otherConfigDTO;
    this.rounds = rounds;
  }

  @ApiModelProperty(readOnly = true, hidden = true)
  @JsonProperty(access = Access.READ_ONLY)
  public String getId() {
    return id;
  }

  @JsonIgnore
  public void setId(String id) {
    this.id = id;
  }

  public GeneralConfigDTO getGeneralConfigDTO() {
    return generalConfigDTO;
  }

  public void setGeneralConfigDTO(
      GeneralConfigDTO generalConfigDTO) {
    this.generalConfigDTO = generalConfigDTO;
  }

  public OtherConfigDTO getOtherConfigDTO() {
    return otherConfigDTO;
  }

  public void setOtherConfigDTO(OtherConfigDTO otherConfigDTO) {
    this.otherConfigDTO = otherConfigDTO;
  }

  public List<RoundDTO> getRounds() {
    return rounds;
  }

  public void setRounds(List<RoundDTO> rounds) {
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
    TournamentDTO that = (TournamentDTO) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(generalConfigDTO, that.generalConfigDTO) &&
        Objects.equals(otherConfigDTO, that.otherConfigDTO) &&
        Objects.equals(rounds, that.rounds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, generalConfigDTO, otherConfigDTO, rounds);
  }

  @Override
  public String toString() {
    return "TournamentDTO{" +
        "id='" + id + '\'' +
        ", generalConfigDTO=" + generalConfigDTO +
        ", otherConfigDTO=" + otherConfigDTO +
        ", rounds=" + rounds +
        '}';
  }
}
