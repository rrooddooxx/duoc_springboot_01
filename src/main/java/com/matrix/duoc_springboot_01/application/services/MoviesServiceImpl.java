package com.matrix.duoc_springboot_01.application.services;

import com.matrix.duoc_springboot_01.domain.Movies;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.MoviesRepository;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.MovieEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.mapper.MoviesMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MoviesServiceImpl implements MoviesService {

  private final MoviesRepository moviesRepository;
  private final MoviesMapper mapper;

  @Override
  public List<Movies> getAllMovies() {
    return moviesRepository.findAll().stream().map(this.mapper::mapMovieEntityToDomain).toList();
  }

  @Override
  public List<Movies> getAllMovies(String offset, String limit) {
    log.info("WITH PAGING!!");
    int pageNumber = Integer.parseInt(offset) / Integer.parseInt(limit);
    Pageable pageable = PageRequest.of(pageNumber, Integer.parseInt(limit));
    Page<MovieEntity> currentPage = moviesRepository.findAll(pageable);
    return currentPage.getContent().stream().map(this.mapper::mapMovieEntityToDomain).toList();
  }

  @Override
  public Optional<Movies> getMovieById(Long movieId) {

    return moviesRepository.findById(movieId).map(this.mapper::mapMovieEntityToDomain);
  }
}
