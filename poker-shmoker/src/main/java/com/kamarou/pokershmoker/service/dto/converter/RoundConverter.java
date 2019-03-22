package com.kamarou.pokershmoker.service.dto.converter;

import com.kamarou.pokershmoker.dao.entity.Round;
import com.kamarou.pokershmoker.service.dto.Converter;
import com.kamarou.pokershmoker.service.dto.entity.RoundDTO;
import org.springframework.stereotype.Component;

@Component
public class RoundConverter implements Converter<RoundDTO, Round> {

  @Override
  public RoundDTO convertToDTO(Round e) {
    return new RoundDTO(e.getId(), e.getPosition(), e.getNumber(), e.getDuration(), e.getTimeLeft(),
        e.isChipUp(), e.getGameName(), e.getGameType(), e.getSmallBlind(), e.getBigBlind(),
        e.getAnte(), e.getRoundType(), e.getTournament().getId());
  }

  @Override
  public Round convertToEntity(RoundDTO d) {
    return new Round(d.getPosition(), d.getNumber(), d.getDuration(), d.getTimeLeft(), d.isChipUp(),
        d.getGameName(), d.getGameType(), d.getSmallBlind(), d.getBigBlind(), d.getAnte(),
        d.getRoundType());
  }
}
