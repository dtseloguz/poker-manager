package com.kamarou.pokershmoker.service.dto.converter;

import com.kamarou.pokershmoker.dao.entity.BuyIn;
import com.kamarou.pokershmoker.service.dto.Converter;
import com.kamarou.pokershmoker.service.dto.entity.BuyInDTO;
import org.springframework.stereotype.Component;

@Component
public class BuyInConverter implements Converter<BuyInDTO, BuyIn> {

  @Override
  public BuyInDTO convertToDTO(BuyIn buyIn) {
    return null;
  }

  @Override
  public BuyIn convertToEntity(BuyInDTO buyInDTO) {
    return null;
  }
}
