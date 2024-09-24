package com.matrix.duoc_springboot_01.infrastructure.controllers;

import com.matrix.duoc_springboot_01.application.services.MoviesServiceImpl;
import com.matrix.duoc_springboot_01.domain.Movies;
import com.matrix.duoc_springboot_01.domain.NewMovie;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
@Slf4j
public class MoviesController {

  private final MoviesServiceImpl moviesService;

  @GetMapping()
  public ResponseEntity<CollectionModel<EntityModel<Movies>>> getAllMovies(
      @RequestParam(required = false) Optional<String> limit,
      @RequestParam(required = false) Optional<String> offset) {
    List<Movies> serviceResponse =
        limit.isPresent() && offset.isPresent()
            ? moviesService.getAllMovies(offset.get(), limit.get())
            : moviesService.getAllMovies();

    if (serviceResponse.isEmpty()) {
      log.error("ERROR! Cant retrieve paginated movies");
      return ResponseEntity.notFound().build();
    }
    log.info("SUCCESS! Got page from paginated movie results");

    List<EntityModel<Movies>> movieResources =
        serviceResponse.stream()
            .map(
                movie ->
                    EntityModel.of(
                        movie,
                        WebMvcLinkBuilder.linkTo(
                                WebMvcLinkBuilder.methodOn(this.getClass())
                                    .getMovieById(movie.getMovieId()))
                            .withSelfRel()))
            .toList();

    WebMvcLinkBuilder linkTo =
        WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(this.getClass())
                .getAllMovies(Optional.empty(), Optional.empty()));

    CollectionModel<EntityModel<Movies>> resources =
        CollectionModel.of(movieResources, linkTo.withRel("movies"));
    return ResponseEntity.ok(resources);
  }

  @GetMapping("/{movieId}")
  public ResponseEntity<EntityModel<Movies>> getMovieById(@PathVariable("movieId") Long movieId) {
    Optional<Movies> moviesById = moviesService.getMovieById(movieId);

    if (moviesById.isEmpty()) {
      log.error("ERROR! Cant get movies from the data store");
      return ResponseEntity.notFound().build();
    }

    log.info("SUCCESS! All movies from data store retrieved");
    Movies movie = moviesById.get();
    EntityModel<Movies> movieResource =
        EntityModel.of(
            movie,
            WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(this.getClass()).getMovieById(movie.getMovieId()))
                .withSelfRel());

    return ResponseEntity.ok(movieResource);
  }

  @PostMapping()
  public ResponseEntity<Long> createMovie(@RequestBody(required = true) NewMovie newMovie) {
    Long newMovieId = this.moviesService.createMovie(newMovie);
    if (newMovieId > 0) {
      log.info(String.format("SUCCESS! New movie created, ID: %d", newMovieId));
      return ResponseEntity.ok(newMovieId);
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/{movieId}")
  public ResponseEntity<Void> deleteMovie(@PathVariable("movieId") Long id) {
    try {
      boolean wasDeleted = this.moviesService.deleteMovieById(id);

      if (!wasDeleted) {
        log.error("Cant delete movie with ID {}", id);
        return ResponseEntity.badRequest().build();
      }
      log.info(String.format("SUCCESS! Deleted movie with ID %s from the data store", id));
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
