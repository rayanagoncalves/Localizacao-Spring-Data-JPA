package io.github.rayanagoncalves.localizacao.services

import io.github.rayanagoncalves.localizacao.domain.entities.City
import io.github.rayanagoncalves.localizacao.repositories.CityRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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
        cityRepository.findByNameLike("%fe").forEach { println("Cidade: ${it.name}-${it.population}") }
    }

    fun getCitiesByPopulation() {
        cityRepository.findByPopulation(49585L).forEach { println("Cidade: ${it.name}-${it.population}") }
    }

    fun getCitiesByPopulationQuantity() {
        cityRepository.findByPopulationLessThan(49593L).forEach { println("Cidade: ${it.name}-${it.population}") }
    }
}