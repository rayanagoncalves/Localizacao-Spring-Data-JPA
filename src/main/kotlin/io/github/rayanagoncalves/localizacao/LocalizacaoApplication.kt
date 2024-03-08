package io.github.rayanagoncalves.localizacao

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
			cityService.getCitiesByNameSpec()
		}
	}
}

fun main(args: Array<String>) {
	runApplication<LocalizacaoApplication>(*args)
}
