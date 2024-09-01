package com.matrix.duoc_springboot_01.infrastructure.database.repositories;

import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<MovieEntity, Long> {}
