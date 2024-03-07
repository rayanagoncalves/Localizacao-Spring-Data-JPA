package io.github.rayanagoncalves.localizacao.repositories

import io.github.rayanagoncalves.localizacao.domain.entities.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CityRepository: JpaRepository<City, Long> {

    fun findByName(name: String): List<City>

    fun findByNameStartingWith(name: String): List<City>

    fun findByNameEndingWith(name: String): List<City>

    fun findByNameContaining(name: String): List<City>

    @Query("select c from City c where upper(c.name) like upper(?1)")
    fun findByNameLike(name: String): List<City>

    fun findByPopulation(population: Long): List<City>

    fun findByPopulationLessThan(population: Long): List<City>

    fun findByPopulationGreaterThan(population: Long): List<City>

    fun findByPopulationLessThanEqual(population: Long): List<City>

    fun findByPopulationLessThanAndNameLike(population: Long, name: String)
}