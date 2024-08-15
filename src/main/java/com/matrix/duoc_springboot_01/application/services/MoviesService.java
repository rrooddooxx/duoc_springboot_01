package com.matrix.duoc_springboot_01.application.services;

import com.matrix.duoc_springboot_01.application.repositories.MoviesRepository;
import com.matrix.duoc_springboot_01.domain.Movies;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MoviesService {

    private final MoviesRepository moviesRepository;

    public List<Movies> getAllMovies() {
        return moviesRepository.getAllMovies();
    }

    public List<Movies> getAllMovies(int limit) {
        return moviesRepository.getMovies(limit);
    }

    public List<Movies> getMovieById(int movieId) {
        return moviesRepository.getAllMovies().stream().filter(movie -> movie.getMovieId() == movieId).toList();
    }
}
