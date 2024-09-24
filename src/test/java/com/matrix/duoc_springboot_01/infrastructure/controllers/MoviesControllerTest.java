package com.matrix.duoc_springboot_01.infrastructure.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matrix.duoc_springboot_01.application.services.MoviesServiceImpl;
import com.matrix.duoc_springboot_01.domain.NewMovie;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(MoviesController.class)
public class MoviesControllerTest {

  @Autowired ObjectMapper objectMapper;
  @Autowired private MockMvc mockMvc;
  @MockBean private MoviesServiceImpl moviesService;

  @Test
  void createNewMovie() throws Exception {
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

    String mockJsonPayload = objectMapper.writeValueAsString(mockNewCreatedMovie);

    Mockito.when(moviesService.createMovie(Mockito.any(NewMovie.class))).thenReturn(99L);

    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/v1/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mockJsonPayload))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andExpect(MockMvcResultMatchers.content().string("99"));
  }
}
