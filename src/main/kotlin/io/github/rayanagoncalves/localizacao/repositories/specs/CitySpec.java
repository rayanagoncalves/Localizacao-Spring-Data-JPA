package io.github.rayanagoncalves.localizacao.repositories.specs;

import io.github.rayanagoncalves.localizacao.domain.entities.City;
import org.springframework.data.jpa.domain.Specification;

public abstract class CitySpec {

    public static Specification<City> nameEqual(String name) {
        return ((root, query, cb) -> cb.equal( root.get("name"), name));
    }

    public static Specification<City> populationGreaterThan(Long population) {
        return ((root, query, cb) -> cb.greaterThan( root.get("population"), population));
    }
}
