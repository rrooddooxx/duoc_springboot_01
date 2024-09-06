package com.matrix.duoc_springboot_01.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Country {
  private Long countryId;
  private String countryName;
}
