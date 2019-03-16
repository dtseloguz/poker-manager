package com.kamarou.pokershmoker.service.impl;

import com.kamarou.pokershmoker.dao.entity.OtherConfig;
import com.kamarou.pokershmoker.dao.repository.OtherConfigRepository;
import com.kamarou.pokershmoker.service.OtherConfigService;
import com.kamarou.pokershmoker.service.dto.converter.OtherConfigConverter;
import com.kamarou.pokershmoker.service.dto.entity.OtherConfigDTO;
import com.kamarou.pokershmoker.service.exception.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherConfigServiceImpl implements OtherConfigService {

  private final OtherConfigRepository configRepository;
  private final OtherConfigConverter configConverter;
  private static final Logger LOG = LoggerFactory.getLogger(OtherConfigRepository.class);
  private static final String NOT_FOUND_CONFIG = "Не найдено конфигурации";

  @Autowired
  public OtherConfigServiceImpl(
      OtherConfigRepository configRepository,
      OtherConfigConverter configConverter) {
    this.configRepository = configRepository;
    this.configConverter = configConverter;
  }

  private List<OtherConfigDTO> convertConfigList(List<OtherConfig> configs) {
    return configs
        .stream()
        .map(configConverter::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional
  @Override
  public OtherConfigDTO updateOtherConfig(OtherConfigDTO configDTO) {
    LOG.info("Update other config");
    Optional<OtherConfig> optionalConfig = configRepository
        .findOtherConfigByTournamentId(configDTO.getTournamentID());
    if (!optionalConfig.isPresent()) {
      LOG.error("Configuration with ID {} not found", configDTO.getId());
      throw new NotFoundException(NOT_FOUND_CONFIG);
    }
    OtherConfig config = optionalConfig.get();
    config.setConfigPresent(configDTO.isConfigPresent());
    config.setGameConfigType(configDTO.getGameConfigType());
    config.setChipsAmount(configDTO.getChipsAmount());
    config.setCommission(configDTO.getCommission());
    return configConverter.convertToDTO(configRepository.save(config));
  }

  @Override
  public OtherConfigDTO selectOtherConfigById(String tournamentId) {
    Optional<OtherConfig> optionalConfig = configRepository
        .findOtherConfigByTournamentId(tournamentId);
    if (!optionalConfig.isPresent()) {
      LOG.error("Configuration with ID {} not found", tournamentId);
      throw new NotFoundException(NOT_FOUND_CONFIG);
    }
    return configConverter.convertToDTO(optionalConfig.get());
  }
}
