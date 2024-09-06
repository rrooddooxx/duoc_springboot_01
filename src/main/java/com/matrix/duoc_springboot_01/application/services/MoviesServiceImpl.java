package com.matrix.duoc_springboot_01.application.services;

import com.matrix.duoc_springboot_01.domain.Movies;
import com.matrix.duoc_springboot_01.domain.NewMovie;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.CountryRepository;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.DirectorRepository;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.LanguageRepository;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.MoviesRepository;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.CountryEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.DirectorEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.LanguageEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.MovieEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.mapper.MoviesMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MoviesServiceImpl implements MoviesService {

  private final MoviesRepository moviesRepository;
  private final DirectorRepository directorRepository;
  private final CountryRepository countryRepository;
  private final LanguageRepository languageRepository;
  private final MoviesMapper mapper;

  @Override
  public List<Movies> getAllMovies() {
    log.info("Getting all movies from data store");
    return moviesRepository.findAll().stream().map(this.mapper::mapMovieEntityToDomain).toList();
  }

  @Override
  public List<Movies> getAllMovies(String offset, String limit) {
    log.info("Getting all movies from data store with paginated results");
    int pageNumber = Integer.parseInt(offset) / Integer.parseInt(limit);
    Pageable pageable = PageRequest.of(pageNumber, Integer.parseInt(limit));
    Page<MovieEntity> currentPage = moviesRepository.findAll(pageable);
    return currentPage.getContent().stream().map(this.mapper::mapMovieEntityToDomain).toList();
  }

  @Override
  public Optional<Movies> getMovieById(Long movieId) {
    return moviesRepository.findById(movieId).map(this.mapper::mapMovieEntityToDomain);
  }

  @Override
  public Long createMovie(NewMovie newMovie) {
    try {
      Optional<DirectorEntity> foundDirector =
          this.directorRepository.findById(newMovie.getDirectorId());
      Optional<LanguageEntity> foundLang =
          this.languageRepository.findById(newMovie.getLanguageId());
      Optional<CountryEntity> foundCountry =
          this.countryRepository.findById(newMovie.getCountryId());

      if (foundDirector.isEmpty() || foundLang.isEmpty() || foundCountry.isEmpty()) {
        String errorMsg = "Director, Language or Country not found, cannot proceed";
        log.error(errorMsg);
        throw new BadRequestException(errorMsg);
      }

      MovieEntity createdMovie =
          this.moviesRepository.save(
              this.mapper.mapDomainToEntity(
                  newMovie, foundDirector.get(), foundLang.get(), foundCountry.get()));

      return createdMovie.getMovieId();
    } catch (Exception e) {
      log.error("Cant insert new movie to data store");
      throw new RuntimeException("Cant insert new movie to data store");
    }
  }

  @Override
  public boolean deleteMovieById(Long id) {
    Optional<Movies> foundMovie = this.getMovieById(id);
    if (foundMovie.isEmpty()) {
      log.error("ERROR! Cant find movie with id {} in the data store, not deleting", id);
      return false;
    }

    this.moviesRepository.deleteById(id);
    return true;
  }
}
