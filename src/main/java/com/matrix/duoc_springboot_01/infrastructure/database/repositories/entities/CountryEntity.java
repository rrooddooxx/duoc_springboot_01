package com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Country")
@Getter
@Setter
public class CountryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "country_id", nullable = false)
  private Long countryId;

  @Column(name = "name")
  private String name;
}
