package io.github.rayanagoncalves.localizacao.services

import io.github.rayanagoncalves.localizacao.domain.entities.City
import io.github.rayanagoncalves.localizacao.repositories.CityRepository
import io.github.rayanagoncalves.localizacao.repositories.specs.CitySpecs
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.StringUtils

@Service
class CityService(
    private val cityRepository: CityRepository
) {
    @Transactional
    fun saveCity() {
        val city = City(1L, "Recife", 1000L)
        cityRepository.save(city)
    }

    fun getCities() {
        cityRepository.findAll().forEach { println("Cidade: ${it.name}-${it.population}") }
    }

    fun getCitiesByName() {
        val pageable = PageRequest.of(0, 10)
        cityRepository.findByNameLike("%fe", pageable).forEach { println("Cidade: ${it.name}-${it.population}") }
    }

    fun getCitiesByPopulation() {
        cityRepository.findByPopulation(49585L).forEach { println("Cidade: ${it.name}-${it.population}") }
    }

    fun getCitiesByPopulationQuantity() {
        cityRepository.findByPopulationLessThan(49593L).forEach { println("Cidade: ${it.name}-${it.population}") }
    }

    fun dynamicFilter(city: City): List<City> {
        val exampleMatcher = ExampleMatcher.matching()
            .withIgnoreCase("name")
            .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
        val example = Example.of(city, exampleMatcher)
        return cityRepository.findAll(example)
    }

    fun getCitiesByNameSpec() {
        val spec = CitySpecs.nameEqual("Recife").and(CitySpecs.populationGreaterThan(1000L))
        cityRepository.findAll(spec).forEach { println("Cidade: ${it.name}-${it.population}") }
    }

    fun getCitiesSpecDynamicFilter(filter: City) {
        var specs = Specification.where { root: Root<City?>?, query: CriteriaQuery<*>?, cb: CriteriaBuilder -> cb.conjunction() }
        // select * from city where 1 = 1

        if(filter.id != null) {
            specs = specs.and(CitySpecs.idEqual(1L))
        }

        if(StringUtils.hasText(filter.name)) {
            specs = specs.and(CitySpecs.nameLike(filter.name!!))
        }

        if(filter.population != null) {
            specs = specs.and(CitySpecs.populationGreaterThan(filter.population!!))
        }

        cityRepository.findAll(specs).forEach { println("Cidade: ${it.name}-${it.population}") }
    }

    fun getCitiesByNameSQL() {
        cityRepository
            .findByNameSql("Recife")
            .map { City(id = it.getId(), name = it.getName()) }
            .forEach { println("${it.id}-${it.name}") }
    }
}