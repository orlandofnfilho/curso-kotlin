package br.com.jofh.usersk_api.dtos

import br.com.jofh.usersk_api.entities.Address
import br.com.jofh.usersk_api.entities.User
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class UserDTO(
    var nome: String,

    @JsonProperty("data-nascimento")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    var dataNascimento: Date,

    var cep: String?,
)

fun User.toDTO(): UserDTO =
    UserDTO(
        nome = this.nome,
        dataNascimento = this.dataNascimento,
        cep = this.address?.cep
    )

fun UserDTO.toDomain(): User =
    User(
        nome = this.nome,
        dataNascimento = this.dataNascimento,
        address = this.cep?.let { Address(cep = it) }
    )


