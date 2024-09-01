package com.matrix.duoc_springboot_01.infrastructure.controllers;

import com.matrix.duoc_springboot_01.application.services.MoviesService;
import com.matrix.duoc_springboot_01.domain.Movies;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class MoviesController {

  private final MoviesService moviesService;

  @GetMapping("/movies")
  public ResponseEntity<List<Movies>> getAllMovies(@RequestParam(required = false) Integer limit) {
    Optional<Integer> limitOptional = Optional.ofNullable(limit);
    List<Movies> serviceResponse =
        limitOptional.isPresent()
            ? moviesService.getAllMovies(limit)
            : moviesService.getAllMovies();
    return serviceResponse.isEmpty()
        ? ResponseEntity.notFound().build()
        : ResponseEntity.ok(serviceResponse);
  }

  @GetMapping("/movies/{movieId}")
  public ResponseEntity<List<Movies>> getMovieById(@PathVariable("movieId") int movieId) {
    List<Movies> moviesById = moviesService.getMovieById(movieId);
    return moviesById.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(moviesById);
  }
}
