package br.com.jofh.usersk_api.entities

import jakarta.persistence.*
import java.util.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val nome: String = "",
    @Temporal(TemporalType.DATE)
    val dataNascimento: Date
)
