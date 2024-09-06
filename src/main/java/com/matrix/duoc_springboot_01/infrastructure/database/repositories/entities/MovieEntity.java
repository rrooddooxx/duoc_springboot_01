package com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Movie")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movie_id")
  private Long movieId;

  @Column(name = "title")
  private String title;

  @ManyToOne
  @JoinColumn(name = "director_id", nullable = false)
  private DirectorEntity director;

  @Column(name = "genre")
  private String genre;

  @Column(name = "year")
  private Integer year;

  @Column(name = "duration")
  private Integer duration;

  @ManyToOne
  @JoinColumn(name = "country_id", nullable = false)
  private CountryEntity country;

  @ManyToOne
  @JoinColumn(name = "language_id", nullable = false)
  private LanguageEntity language;

  @Column(name = "rating")
  private String rating;

  @Column(name = "synopsis")
  private String synopsis;
}
