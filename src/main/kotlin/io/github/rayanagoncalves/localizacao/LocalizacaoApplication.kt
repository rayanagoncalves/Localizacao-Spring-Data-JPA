package io.github.rayanagoncalves.localizacao

import io.github.rayanagoncalves.localizacao.domain.entities.City
import io.github.rayanagoncalves.localizacao.repositories.CityRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.transaction.annotation.Transactional

@SpringBootApplication
class LocalizacaoApplication(private val cityRepository: CityRepository) {

	@Bean
	fun init(): CommandLineRunner {
		return CommandLineRunner {
		//	getCities()
			getCitiesByName()
		//	getCitiesByPopulation()
		}
	}

	@Transactional
	fun saveCity() {
		val city = City(1L, "Recife", 1000L)
		cityRepository.save(city)
	}

	fun getCities() {
		cityRepository.findAll().forEach { println("Cidade: ${it.name}-${it.population}") }
	}

	fun getCitiesByName() {
		cityRepository.findByNameStartingWith("Porto").forEach { println("Cidade: ${it.name}-${it.population}") }
	}

	fun getCitiesByPopulation() {
		cityRepository.findByPopulation(49585L).forEach { println("Cidade: ${it.name}-${it.population}") }
	}
}

fun main(args: Array<String>) {
	runApplication<LocalizacaoApplication>(*args)
}
