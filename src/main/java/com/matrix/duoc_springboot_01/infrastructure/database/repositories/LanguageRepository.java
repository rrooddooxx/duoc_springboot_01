package com.matrix.duoc_springboot_01.infrastructure.database.repositories;

import com.matrix.duoc_springboot_01.infrastructure.database.repositories.entities.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {}
