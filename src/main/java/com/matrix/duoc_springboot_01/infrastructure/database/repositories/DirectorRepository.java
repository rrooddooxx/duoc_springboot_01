package com.matrix.duoc_springboot_01.infrastructure.database.repositories;

import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {}
