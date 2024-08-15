package com.matrix.duoc_springboot_01.infrastructure.controllers;

import com.matrix.duoc_springboot_01.application.services.MoviesService;
import com.matrix.duoc_springboot_01.domain.Movies;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MoviesController {

    private final MoviesService moviesService;

    @GetMapping("/movies")
    public List<Movies> getAllMovies(@RequestParam(required = false) Integer limit) {
        Optional<Integer> limitOptional = Optional.ofNullable(limit);
        return limitOptional.isPresent() ? moviesService.getAllMovies(limit) : moviesService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}")
    public List<Movies> getMovieById(
            @PathVariable int movieId
    ) {
        return moviesService.getMovieById(movieId);
    }
}
