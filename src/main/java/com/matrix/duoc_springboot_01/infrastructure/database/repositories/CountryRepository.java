package com.matrix.duoc_springboot_01.infrastructure.database.repositories;

import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {}
