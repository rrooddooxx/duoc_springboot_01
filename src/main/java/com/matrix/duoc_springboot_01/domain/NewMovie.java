package com.matrix.duoc_springboot_01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewMovie {
  private String title;
  private Long directorId;
  private String genre;
  private int year;
  private int duration;
  private Long countryId;
  private Long languageId;
  private String rating;
  private String synopsis;
}
