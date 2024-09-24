package com.matrix.duoc_springboot_01.application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.matrix.duoc_springboot_01.domain.NewMovie;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.CountryRepository;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.DirectorRepository;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.LanguageRepository;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.MoviesRepository;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.CountryEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.DirectorEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.LanguageEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.MovieEntity;
import com.matrix.duoc_springboot_01.infrastructure.database.repositories.mapper.MoviesMapper;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MoviesServiceTests {

  @Mock MoviesRepository moviesRepository;

  @Mock DirectorRepository directorRepository;

  @Mock LanguageRepository languageRepository;

  @Mock CountryRepository countryRepository;

  @Mock MoviesMapper mapper;

  @InjectMocks MoviesServiceImpl moviesService;

  @Test
  void testCreateMovie() {
    NewMovie mockNewCreatedMovie =
        NewMovie.builder()
            .genre("Fake Documentary Movie")
            .title("A fake movie")
            .rating("TE")
            .year(2009)
            .directorId(2L)
            .countryId(1L)
            .languageId(1L)
            .synopsis("A really fake movie")
            .duration(120)
            .build();

    CountryEntity directorCountry = CountryEntity.builder().countryId(1L).name("USA").build();

    DirectorEntity director =
        DirectorEntity.builder()
            .directorId(1L)
            .firstName("John")
            .lastName("Doe")
            .country(directorCountry)
            .birthDate(LocalDate.of(1970, 1, 1))
            .deathDate(null)
            .build();

    CountryEntity movieCountry = CountryEntity.builder().countryId(2L).name("Canada").build();

    LanguageEntity language = LanguageEntity.builder().langId(1L).name("English").build();

    MovieEntity movieToSave =
        MovieEntity.builder()
            .movieId(1L)
            .title(mockNewCreatedMovie.getTitle())
            .director(director)
            .genre(mockNewCreatedMovie.getGenre())
            .year(mockNewCreatedMovie.getYear())
            .duration(mockNewCreatedMovie.getDuration())
            .country(movieCountry)
            .language(language)
            .rating(mockNewCreatedMovie.getRating())
            .synopsis(mockNewCreatedMovie.getSynopsis())
            .build();

    when(mapper.mapDomainToEntity(mockNewCreatedMovie, director, language, movieCountry))
        .thenReturn(movieToSave);
    when(directorRepository.findById(mockNewCreatedMovie.getDirectorId()))
        .thenReturn(Optional.of(director));
    when(languageRepository.findById(mockNewCreatedMovie.getLanguageId()))
        .thenReturn(Optional.of(language));
    when(countryRepository.findById(mockNewCreatedMovie.getCountryId()))
        .thenReturn(Optional.of(movieCountry));
    when(moviesRepository.save(movieToSave)).thenReturn(movieToSave);

    Long result = this.moviesService.createMovie(mockNewCreatedMovie);

    verify(directorRepository).findById(mockNewCreatedMovie.getDirectorId());
    verify(languageRepository).findById(mockNewCreatedMovie.getLanguageId());
    verify(countryRepository).findById(mockNewCreatedMovie.getCountryId());
    verify(moviesRepository).save(movieToSave);

    assertEquals(1L, result);
  }
}
