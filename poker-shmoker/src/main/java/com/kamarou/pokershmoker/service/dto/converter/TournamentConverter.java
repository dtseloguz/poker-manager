package com.kamarou.pokershmoker.service.dto.converter;

import com.kamarou.pokershmoker.dao.entity.GeneralConfig;
import com.kamarou.pokershmoker.dao.entity.OtherConfig;
import com.kamarou.pokershmoker.dao.entity.Tournament;
import com.kamarou.pokershmoker.service.dto.Converter;
import com.kamarou.pokershmoker.service.dto.entity.TournamentDTO;
import java.util.HashSet;
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
    return new TournamentDTO(entity.getId(),
        generalConfigConverter.convertToDTO(entity.getGeneralConfig()),
        otherConfigConverter.convertToDTO(entity.getOtherConfig()),
        entity.getRounds().stream().map(roundConverter::convertToDTO).collect(Collectors.toList()));
  }

  @Override
  public Tournament convertToEntity(TournamentDTO t) {
    return new Tournament(new GeneralConfig(), new OtherConfig(),new HashSet<>());
  }
}
