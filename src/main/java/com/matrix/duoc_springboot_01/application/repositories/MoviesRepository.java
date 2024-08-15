package com.matrix.duoc_springboot_01.application.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matrix.duoc_springboot_01.domain.Movies;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesRepository {
    private final ArrayList<Movies> movieList = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.loadUsers();
    }

    private void loadUsers() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Movies>> typeRef = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/movies.json");
        try {
            List<Movies> parsedMovies = mapper.readValue(inputStream, typeRef);
            movieList.addAll(parsedMovies);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movies> getMovies(int limit) {
        return this.movieList.subList(0, limit);
    }

    public List<Movies> getAllMovies() {
        System.out.println(this.movieList);
        return this.movieList;
    }

}
