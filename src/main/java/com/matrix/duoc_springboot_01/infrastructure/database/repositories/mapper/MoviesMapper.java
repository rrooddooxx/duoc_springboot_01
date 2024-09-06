package com.matrix.duoc_springboot_01.infrastructure.database.repositories.mapper;

import com.matrix.duoc_springboot_01.domain.*;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.CountryEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.DirectorEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.LanguageEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.MovieEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MoviesMapper {
  public Movies mapMovieEntityToDomain(MovieEntity movieEntity) {
    try {
      return Movies.builder()
          .movieId(movieEntity.getMovieId())
          .title(movieEntity.getTitle())
          .director(this.mapDirectorEntityToDomain(movieEntity.getDirector()))
          .genre(movieEntity.getGenre())
          .year(movieEntity.getYear())
          .duration(movieEntity.getDuration())
          .country(
              Country.builder()
                  .countryId(movieEntity.getCountry().getCountryId())
                  .countryName(movieEntity.getCountry().getName())
                  .build())
          .language(
              Language.builder()
                  .langId(movieEntity.getLanguage().getLangId())
                  .langName(movieEntity.getLanguage().getName())
                  .build())
          .rating(movieEntity.getRating())
          .synopsis(movieEntity.getSynopsis())
          .build();
    } catch (Exception e) {
      String logMsg = String.format("Error mapping MovieEntity to Movies: %s", e.getMessage());
      log.error(logMsg);
      return null;
    }
  }

  public MovieEntity mapDomainToEntity(
      NewMovie movie,
      DirectorEntity movieDirector,
      LanguageEntity movieLanguage,
      CountryEntity movieCountry) {
    return MovieEntity.builder()
        .genre(movie.getGenre())
        .title(movie.getTitle())
        .year(movie.getYear())
        .rating(movie.getRating())
        .language(movieLanguage)
        .synopsis(movie.getSynopsis())
        .country(movieCountry)
        .duration(movie.getDuration())
        .director(movieDirector)
        .build();
  }

  public MoviesDirector mapDirectorEntityToDomain(DirectorEntity directorEntity) {
    return MoviesDirector.builder()
        .directorId(directorEntity.getDirectorId())
        .firstName(directorEntity.getFirstName())
        .lastName(directorEntity.getLastName())
        .country(
            Country.builder()
                .countryId(directorEntity.getCountry().getCountryId())
                .countryName(directorEntity.getCountry().getName())
                .build())
        .birthDate(directorEntity.getBirthDate())
        .deathDate(directorEntity.getDeathDate())
        .build();
  }
}
