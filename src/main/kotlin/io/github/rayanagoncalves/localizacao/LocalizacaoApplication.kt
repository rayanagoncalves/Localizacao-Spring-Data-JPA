package io.github.rayanagoncalves.localizacao

import io.github.rayanagoncalves.localizacao.domain.entities.City
import io.github.rayanagoncalves.localizacao.services.CityService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class LocalizacaoApplication(private val cityService: CityService) {

	@Bean
	fun init(): CommandLineRunner {
		return CommandLineRunner {
			val city = City(1L, "Recife", 1000L)
			cityService.getCitiesByNameSQL()
		}
	}
}

fun main(args: Array<String>) {
	runApplication<LocalizacaoApplication>(*args)
}
