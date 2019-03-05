package com.kamarou.pokershmoker.service.impl;

import com.kamarou.pokershmoker.dao.entity.Tournament;
import com.kamarou.pokershmoker.dao.repository.TournamentRepository;
import com.kamarou.pokershmoker.service.TournamentService;
import com.kamarou.pokershmoker.service.dto.converter.TournamentConverter;
import com.kamarou.pokershmoker.service.dto.entity.TournamentDTO;
import com.kamarou.pokershmoker.service.exception.NotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TournamentServiceImpl implements TournamentService {

  private final TournamentRepository tournamentRepository;
  private final TournamentConverter tournamentConverter;
  private static final Logger LOG = LoggerFactory.getLogger(TournamentServiceImpl.class);
  private static final String TOURNAMENT_NOT_FOUND = "Турнир не найден";

  public TournamentServiceImpl(
      TournamentRepository tournamentRepository,
      TournamentConverter tournamentConverter) {
    this.tournamentRepository = tournamentRepository;
    this.tournamentConverter = tournamentConverter;
  }

  private List<TournamentDTO> convertToList(Collection<Tournament> players) {
    return players.stream()
        .map(tournamentConverter::convertToDTO)
        .collect(Collectors.toList());
  }

  @Override
  public TournamentDTO saveTournament(TournamentDTO tournamentDTO) {
    Tournament tournament = tournamentConverter.convertToEntity(tournamentDTO);
    LOG.info("Create tournament: {}", tournament);
    return tournamentConverter.convertToDTO(tournamentRepository.save(tournament));
  }

  @Override
  public TournamentDTO selectTournamentById(String id) {
    Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
    LOG.info("Select tournament with ID: {}", id);
    if (!optionalTournament.isPresent()) {
      LOG.error("Tournament not found.", id);
      throw new NotFoundException(TOURNAMENT_NOT_FOUND);
    }
    Tournament tournament = optionalTournament.get();
    return tournamentConverter.convertToDTO(tournament);
  }

  @Override
  public List<TournamentDTO> selectAllTournaments() {
    return convertToList(tournamentRepository.findAll());
  }

  @Override
  public void deleteTournamentById(String id) {
    if (!tournamentRepository.existsById(id)) {
      LOG.error("Tournament with ID {} not found.", id);
      throw new NotFoundException(TOURNAMENT_NOT_FOUND);
    }
    LOG.info("Delete tournament with ID: {}", id);
    tournamentRepository.deleteById(id);
  }
}
