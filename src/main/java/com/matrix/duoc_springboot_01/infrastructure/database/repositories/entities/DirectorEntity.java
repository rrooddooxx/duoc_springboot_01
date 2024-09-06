package com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "Director")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectorEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "director_id", nullable = false)
  private Long directorId;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @ManyToOne
  @JoinColumn(name = "country_id", nullable = false)
  private CountryEntity country;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @Column(name = "death_date")
  private LocalDate deathDate;
}
