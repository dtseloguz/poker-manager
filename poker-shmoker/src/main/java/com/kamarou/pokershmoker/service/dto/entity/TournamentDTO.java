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
  private String tournamentName;
  private String tournamentDescription;

  public TournamentDTO() {
  }

  public TournamentDTO(String id,
      GeneralConfigDTO generalConfigDTO,
      OtherConfigDTO otherConfigDTO,
      List<RoundDTO> rounds, String tournamentName, String tournamentDescription) {
    this.id = id;
    this.generalConfigDTO = generalConfigDTO;
    this.otherConfigDTO = otherConfigDTO;
    this.rounds = rounds;
    this.tournamentName = tournamentName;
    this.tournamentDescription = tournamentDescription;
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

  @ApiModelProperty(readOnly = true, hidden = true)
  @JsonProperty(access = Access.READ_ONLY)
  public GeneralConfigDTO getGeneralConfigDTO() {
    return generalConfigDTO;
  }

  @JsonIgnore
  public void setGeneralConfigDTO(
      GeneralConfigDTO generalConfigDTO) {
    this.generalConfigDTO = generalConfigDTO;
  }

  @ApiModelProperty(readOnly = true, hidden = true)
  @JsonProperty(access = Access.READ_ONLY)
  public OtherConfigDTO getOtherConfigDTO() {
    return otherConfigDTO;
  }

  @JsonIgnore
  public void setOtherConfigDTO(OtherConfigDTO otherConfigDTO) {
    this.otherConfigDTO = otherConfigDTO;
  }

  @ApiModelProperty(readOnly = true, hidden = true)
  @JsonProperty(access = Access.READ_ONLY)
  public List<RoundDTO> getRounds() {
    return rounds;
  }

  @JsonIgnore
  public void setRounds(List<RoundDTO> rounds) {
    this.rounds = rounds;
  }

  public String getTournamentName() {
    return tournamentName;
  }

  public void setTournamentName(String tournamentName) {
    this.tournamentName = tournamentName;
  }

  public String getTournamentDescription() {
    return tournamentDescription;
  }

  public void setTournamentDescription(String tournamentDescription) {
    this.tournamentDescription = tournamentDescription;
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
    return Objects.equals(generalConfigDTO, that.generalConfigDTO) &&
        Objects.equals(otherConfigDTO, that.otherConfigDTO) &&
        Objects.equals(rounds, that.rounds) &&
        Objects.equals(tournamentName, that.tournamentName) &&
        Objects.equals(tournamentDescription, that.tournamentDescription);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(generalConfigDTO, otherConfigDTO, rounds, tournamentName, tournamentDescription);
  }

  @Override
  public String toString() {
    return "TournamentDTO{" +
        "id='" + id + '\'' +
        ", generalConfigDTO=" + generalConfigDTO +
        ", otherConfigDTO=" + otherConfigDTO +
        ", rounds=" + rounds +
        ", tournamentName='" + tournamentName + '\'' +
        ", tournamentDescription='" + tournamentDescription + '\'' +
        '}';
  }
}
