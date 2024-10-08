package com.matrix.duoc_springboot_01.application.services;

import com.matrix.duoc_springboot_01.domain.Movies;
import com.matrix.duoc_springboot_01.domain.NewMovie;
import java.util.List;
import java.util.Optional;

public interface MoviesService {
  List<Movies> getAllMovies();

  List<Movies> getAllMovies(String offset, String limit);

  Optional<Movies> getMovieById(Long movieId);

  Long createMovie(NewMovie newMovie);

  boolean deleteMovieById(Long id);
}
