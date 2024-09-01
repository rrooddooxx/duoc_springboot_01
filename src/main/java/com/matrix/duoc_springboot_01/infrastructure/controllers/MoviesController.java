package com.matrix.duoc_springboot_01.infrastructure.controllers;

import com.matrix.duoc_springboot_01.application.services.MoviesServiceImpl;
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

  private final MoviesServiceImpl moviesService;

  @GetMapping("/movies")
  public ResponseEntity<List<Movies>> getAllMovies(
      @RequestParam(required = false) Optional<String> limit,
      @RequestParam(required = false) Optional<String> offset) {
    List<Movies> serviceResponse =
        limit.isPresent() && offset.isPresent()
            ? moviesService.getAllMovies(offset.get(), limit.get())
            : moviesService.getAllMovies();
    return serviceResponse.isEmpty()
        ? ResponseEntity.notFound().build()
        : ResponseEntity.ok(serviceResponse);
  }

  @GetMapping("/movies/{movieId}")
  public ResponseEntity<Movies> getMovieById(@PathVariable("movieId") Long movieId) {
    Optional<Movies> moviesById = moviesService.getMovieById(movieId);
    return moviesById.isEmpty()
        ? ResponseEntity.notFound().build()
        : ResponseEntity.ok(moviesById.get());
  }
}
