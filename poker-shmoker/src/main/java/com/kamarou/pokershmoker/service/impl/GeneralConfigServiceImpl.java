package com.kamarou.pokershmoker.service.impl;

import com.kamarou.pokershmoker.dao.entity.GeneralConfig;
import com.kamarou.pokershmoker.dao.repository.GeneralConfigRepository;
import com.kamarou.pokershmoker.service.GeneralConfigService;
import com.kamarou.pokershmoker.service.dto.converter.GeneralConfigConverter;
import com.kamarou.pokershmoker.service.dto.entity.GeneralConfigDTO;
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
public class GeneralConfigServiceImpl implements GeneralConfigService {

  private final GeneralConfigRepository configRepository;
  private final GeneralConfigConverter configConverter;
  private static final Logger LOG = LoggerFactory.getLogger(GeneralConfigServiceImpl.class);
  private static final String NOT_FOUND_CONFIG = "Не найдено конфигурации";

  @Autowired
  public GeneralConfigServiceImpl(
      GeneralConfigRepository configRepository,
      GeneralConfigConverter configConverter) {
    this.configRepository = configRepository;
    this.configConverter = configConverter;
  }

  private List<GeneralConfigDTO> convertConfigList(List<GeneralConfig> configs) {
    return configs
        .stream()
        .map(configConverter::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional
  @Override
  public GeneralConfigDTO saveGeneralConfig(GeneralConfigDTO configDTO) {
    LOG.info("Save general config");
    GeneralConfig generalConfig = configConverter.convertToEntity(configDTO);
    return configConverter.convertToDTO(generalConfig);
  }

  @Transactional
  @Override
  public GeneralConfigDTO updateGeneralConfig(GeneralConfigDTO configDTO) {
    LOG.info("Update general config");
    Optional<GeneralConfig> optionalConfig = configRepository.findById(configDTO.getId());
    if (!optionalConfig.isPresent()) {
      LOG.error("Config with ID {} not found", configDTO.getId());
      throw new NotFoundException(NOT_FOUND_CONFIG);
    }
    GeneralConfig generalConfig = optionalConfig.get();
    generalConfig.setBuyIn(configDTO.getBuyIn());
    generalConfig.setDescription(configDTO.getTournamentDescription());
    generalConfig.setTournamentName(configDTO.getTournamentName());
    generalConfig.setChipsAmount(configDTO.getChipsAmount());
    generalConfig.setCommission(configDTO.getCommission());
    return configConverter.convertToDTO(configRepository.save(generalConfig));
  }

  @Override
  public GeneralConfigDTO selectGeneralConfigById(String id) {
    LOG.info("Select general config by id: {}", id);
    Optional<GeneralConfig> optionalConfig = configRepository.findById(id);
    if (!optionalConfig.isPresent()) {
      LOG.error("General config with ID {} doesn't exist", id);
      throw new NotFoundException(NOT_FOUND_CONFIG);
    }
    return configConverter.convertToDTO(optionalConfig.get());
  }

  @Transactional
  @Override
  public void deleteGeneralConfig(String id) {
    LOG.info("Delete general config by id: {}", id);
    Optional<GeneralConfig> optionalConfig = configRepository.findById(id);
    if (!optionalConfig.isPresent()) {
      LOG.error("General config with ID {} doesn't exist", id);
      throw new NotFoundException(NOT_FOUND_CONFIG);
    }
    configRepository.deleteById(id);
  }

  @Override
  public List<GeneralConfigDTO> selectAllConfigs() {
    return convertConfigList(configRepository.findAll());
  }
}
