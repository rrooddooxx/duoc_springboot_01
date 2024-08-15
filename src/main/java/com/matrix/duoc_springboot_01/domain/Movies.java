package com.matrix.duoc_springboot_01.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movies {
    @JsonProperty("movieId")
    @Getter
    int movieId;

    @JsonProperty("title")
    String title;

    @JsonProperty("director")
    MoviesDirector director;

    @JsonProperty("genre")
    String genre;

    @JsonProperty("year")
    int year;

    @JsonProperty("duration")
    int duration;

    @JsonProperty("country")
    String country;

    @JsonProperty("language")
    String language;

    @JsonProperty("rating")
    String rating;

}
