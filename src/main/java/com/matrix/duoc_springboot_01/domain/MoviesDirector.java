package com.matrix.duoc_springboot_01.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDirector {

  @JsonProperty("first_name")
  String firstName;

  @JsonProperty("last_name")
  String lastName;

  @JsonProperty("country")
  String country;

  @JsonProperty("birth_date")
  LocalDate birthDate;

  @JsonProperty("death_date")
  LocalDate deathDate;
}
