package io.github.rayanagoncalves.localizacao.repositories.specs

import io.github.rayanagoncalves.localizacao.domain.entities.City
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

abstract class CitySpecs {

    companion object {
        fun nameEqual(name: String): Specification<City?> {
            return Specification { root: Root<City?>, query: CriteriaQuery<*>, cb: CriteriaBuilder ->
                cb.equal(
                    root.get<Any>(
                        "name"
                    ), name
                )
            }
        }

        fun populationGreaterThan(population: Long): Specification<City?>? {
            return Specification { root: Root<City?>, query: CriteriaQuery<*>?, cb: CriteriaBuilder ->
                cb.greaterThan(
                    root.get("population"),
                    population
                )
            }
        }
    }
}