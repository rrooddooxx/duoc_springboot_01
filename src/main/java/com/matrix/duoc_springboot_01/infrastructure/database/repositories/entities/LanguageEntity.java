package com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Language")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "lang_id", nullable = false)
  private Long langId;

  @Column(name = "name")
  private String name;
}
