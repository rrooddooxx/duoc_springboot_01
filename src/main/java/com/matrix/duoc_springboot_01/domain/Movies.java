package com.matrix.duoc_springboot_01.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movies extends RepresentationModel<Movies> {
  @JsonProperty("movie_id")
  @Getter
  Long movieId;

  @JsonProperty("title")
  private String title;

  @JsonProperty("director")
  private MoviesDirector director;

  @JsonProperty("genre")
  private String genre;

  @JsonProperty("year")
  private int year;

  @JsonProperty("duration")
  private int duration;

  @JsonProperty("country")
  private Country country;

  @JsonProperty("language")
  private Language language;

  @JsonProperty("rating")
  private String rating;

  @JsonProperty("synopsis")
  private String synopsis;
}
