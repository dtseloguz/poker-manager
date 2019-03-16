package com.kamarou.pokershmoker.service.dto.converter;

import com.kamarou.pokershmoker.dao.entity.GeneralConfig;
import com.kamarou.pokershmoker.dao.entity.OtherConfig;
import com.kamarou.pokershmoker.dao.entity.Round;
import com.kamarou.pokershmoker.dao.entity.Tournament;
import com.kamarou.pokershmoker.service.dto.Converter;
import com.kamarou.pokershmoker.service.dto.entity.GeneralConfigDTO;
import com.kamarou.pokershmoker.service.dto.entity.OtherConfigDTO;
import com.kamarou.pokershmoker.service.dto.entity.RoundDTO;
import com.kamarou.pokershmoker.service.dto.entity.TournamentDTO;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TournamentConverter implements Converter<TournamentDTO, Tournament> {

  private final GeneralConfigConverter generalConfigConverter;
  private final OtherConfigConverter otherConfigConverter;
  private final RoundConverter roundConverter;

  @Autowired
  public TournamentConverter(
      GeneralConfigConverter generalConfigConverter,
      OtherConfigConverter otherConfigConverter,
      RoundConverter roundConverter) {
    this.generalConfigConverter = generalConfigConverter;
    this.otherConfigConverter = otherConfigConverter;
    this.roundConverter = roundConverter;
  }

  @Override
  public TournamentDTO convertToDTO(Tournament entity) {
    GeneralConfigDTO configDTO = new GeneralConfigDTO(entity.getGeneralConfig().getId(),
        entity.getGeneralConfig().getTournamentName(), entity.getGeneralConfig().getDescription(),
        entity.getGeneralConfig().getBuyIn(), entity.getGeneralConfig().getChipsAmount(),
        entity.getGeneralConfig().getCommission(),
        entity.getGeneralConfig().getTournament().getId());
    OtherConfigDTO otherConfigDTO = new OtherConfigDTO(entity.getOtherConfig().getId(),
        entity.getOtherConfig().getGameConfigType(),
        entity.getOtherConfig().getChipsAmount(), entity.getOtherConfig().getCommission(),
        entity.getOtherConfig().isConfigPresent(),
        entity.getOtherConfig().getTournament().getId());
    return new TournamentDTO(entity.getId(),
        configDTO,
        otherConfigDTO,
        entity.getRounds().stream().map(roundConverter::convertToDTO).collect(Collectors.toList()));
  }

  @Override
  public Tournament convertToEntity(TournamentDTO t) {
    Tournament tournament = new Tournament();

    GeneralConfigDTO generalConfigDTO = t.getGeneralConfigDTO();
    GeneralConfig generalConfig = new GeneralConfig(generalConfigDTO.getCommission(),
        generalConfigDTO.getChipsAmount(),
        generalConfigDTO.getTournamentName(), generalConfigDTO.getTournamentDescription(),
        generalConfigDTO.getBuyIn(), tournament);
    tournament.setGeneralConfig(generalConfig);

    OtherConfigDTO otherConfigDTO = t.getOtherConfigDTO();
    OtherConfig otherConfig = new OtherConfig(otherConfigDTO.getCommission(),
        otherConfigDTO.getChipsAmount(), otherConfigDTO.getGameConfigType(),
        otherConfigDTO.isConfigPresent());
    otherConfig.setTournament(tournament);
    List<RoundDTO> roundDTOS = t.getRounds();
    tournament.setOtherConfig(otherConfig);

    Set<Round> rounds = roundDTOS.stream().map(roundDTO -> {
      Round round = roundConverter.convertToEntity(roundDTO);
      round.setTournament(tournament);
      return round;
    }).collect(Collectors.toSet());
    tournament.setRounds(rounds);
    return tournament;
  }
}
