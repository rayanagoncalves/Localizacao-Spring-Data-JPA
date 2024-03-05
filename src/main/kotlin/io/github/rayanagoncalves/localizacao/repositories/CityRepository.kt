package io.github.rayanagoncalves.localizacao.repositories

import io.github.rayanagoncalves.localizacao.domain.entities.City
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository: JpaRepository<City, Long>