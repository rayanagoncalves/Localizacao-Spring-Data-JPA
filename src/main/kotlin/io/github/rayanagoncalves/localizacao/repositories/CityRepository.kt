package io.github.rayanagoncalves.localizacao.repositories

import io.github.rayanagoncalves.localizacao.domain.entities.City
import io.github.rayanagoncalves.localizacao.repositories.projections.CityProjections
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CityRepository: JpaRepository<City, Long>, JpaSpecificationExecutor<City> {

    @Query(nativeQuery = true, value = "select c.id, c.name from tb_city as c where c.name = :name")
    fun findByNameSql(name: String): List<CityProjections>

    fun findByName(name: String): List<City>

    fun findByNameStartingWith(name: String): List<City>

    fun findByNameEndingWith(name: String): List<City>

    fun findByNameContaining(name: String): List<City>

    @Query("select c from City c where upper(c.name) like upper(?1)")
    fun findByNameLike(name: String, pageable: Pageable): Page<City>

    fun findByPopulation(population: Long): List<City>

    fun findByPopulationLessThan(population: Long): List<City>

    fun findByPopulationGreaterThan(population: Long): List<City>

    fun findByPopulationLessThanEqual(population: Long): List<City>

    fun findByPopulationLessThanAndNameLike(population: Long, name: String)
}