package io.github.rayanagoncalves.localizacao.repositories

import io.github.rayanagoncalves.localizacao.domain.entities.City
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository: JpaRepository<City, Long> {

    fun findByName(name: String): List<City>

    fun findByNameStartingWith(name: String): List<City>

    fun findByNameEndingWith(name: String): List<City>

    fun findByNameContaining(name: String): List<City>

    fun findByPopulation(population: Long): List<City>
}