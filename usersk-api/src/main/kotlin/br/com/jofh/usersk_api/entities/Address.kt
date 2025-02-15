package br.com.jofh.usersk_api.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "ADDRESS", schema = "dbo", catalog = "Avaliacao")
data class Address(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    var id: Long = 0,

    var cep: String = "",

    var logradouro: String = "",

    var bairro: String = "",

    @JsonProperty("localidade")
    var cidade: String = "",

    var uf: String = "",

)
