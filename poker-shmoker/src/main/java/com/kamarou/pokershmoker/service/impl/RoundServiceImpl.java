package com.kamarou.pokershmoker.service.impl;

import com.kamarou.pokershmoker.dao.repository.RoundRepository;
import com.kamarou.pokershmoker.service.RoundService;
import com.kamarou.pokershmoker.service.dto.converter.RoundConverter;
import com.kamarou.pokershmoker.service.dto.entity.RoundDTO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService {

  private final RoundRepository roundRepository;
  private final RoundConverter converter;

  private static final Logger LOG = LoggerFactory.getLogger(RoundServiceImpl.class);

  @Autowired
  public RoundServiceImpl(RoundRepository roundRepository,
      RoundConverter converter) {
    this.roundRepository = roundRepository;
    this.converter = converter;
  }

  @Override
  public RoundDTO saveRound(RoundDTO roundDTO) {
    return null;
  }

  @Override
  public RoundDTO updateRound(RoundDTO roundDTO) {
    return null;
  }

  @Override
  public RoundDTO selectRoundById(String id) {
    return null;
  }

  @Override
  public void deleteRoundById(String id) {

  }

  @Override
  public List<RoundDTO> selectRoundSortedByPosition() {
    return null;
  }
}
