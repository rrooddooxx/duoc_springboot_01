package com.matrix.duoc_springboot_01.infrastructure.database.repositories.mapper;

import com.matrix.duoc_springboot_01.domain.Movies;
import com.matrix.duoc_springboot_01.domain.MoviesDirector;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.DirectorEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MoviesMapper {
  public Movies mapMovieEntityToDomain(MovieEntity movieEntity) {
    return Movies.builder()
        .movieId(movieEntity.getMovieId())
        .title(movieEntity.getTitle())
        .director(this.mapDirectorEntityToDomain(movieEntity.getDirector()))
        .genre(movieEntity.getGenre())
        .year(movieEntity.getYear())
        .duration(movieEntity.getDuration())
        .country(movieEntity.getCountry().getName())
        .language(movieEntity.getLanguage().getName())
        .rating(movieEntity.getRating())
        .synopsis(movieEntity.getSynopsis())
        .build();
  }

  public MoviesDirector mapDirectorEntityToDomain(DirectorEntity directorEntity) {
    return MoviesDirector.builder()
        .firstName(directorEntity.getFirstName())
        .lastName(directorEntity.getLastName())
        .country(directorEntity.getCountry().getName())
        .birthDate(directorEntity.getBirthDate())
        .deathDate(directorEntity.getDeathDate())
        .build();
  }
}
