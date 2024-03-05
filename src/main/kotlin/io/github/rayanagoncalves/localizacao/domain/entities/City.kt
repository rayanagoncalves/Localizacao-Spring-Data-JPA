package io.github.rayanagoncalves.localizacao.domain.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_city")
class City(
    @Id
    var id: Long? = null,
    @Column(length = 50)
    var name: String? = null,
    var population: Long? = null
)