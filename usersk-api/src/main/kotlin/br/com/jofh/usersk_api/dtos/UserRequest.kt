package br.com.jofh.usersk_api.dtos

import br.com.jofh.usersk_api.entities.Address
import br.com.jofh.usersk_api.entities.User
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserRequest(
    @field:NotBlank
    var nome: String,

    var cpfCnpj: String,

    @JsonProperty("data-nascimento")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    var dataNascimento: Date,

    var cep: String? = null
)

fun User.toResponse(): UserResponse =
    UserResponse(
        id = this.id,
        nome = this.nome,
        cpfCnpj = this.cpfCnpj,
        dataNascimento = this.dataNascimento,
        address = this.address
    )

fun UserRequest.toDomain(): User =
    User(
        nome = this.nome,
        cpfCnpj = this.cpfCnpj,
        dataNascimento = this.dataNascimento,
        address = this.cep?.let { Address(cep = it) }
    )

