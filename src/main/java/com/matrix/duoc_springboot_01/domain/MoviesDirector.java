package com.matrix.duoc_springboot_01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDirector {
    String name;
    String lastName;
    String country;
    Date birthDate;
    Date deathDate;
}
