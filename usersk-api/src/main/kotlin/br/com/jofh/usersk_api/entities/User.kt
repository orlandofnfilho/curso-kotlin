package br.com.jofh.usersk_api.entities

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "USERS", schema = "dbo", catalog = "Avaliacao")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var nome: String = "",

    @Column(unique = true)
    var cpfCnpj: String = "",

    @Temporal(TemporalType.DATE)
    var dataNascimento: Date,

    @OneToOne(cascade = [CascadeType.ALL])
    var address: Address?
)
