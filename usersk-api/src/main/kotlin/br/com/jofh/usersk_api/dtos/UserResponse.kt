package br.com.jofh.usersk_api.dtos

import br.com.jofh.usersk_api.entities.Address
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserResponse(
    var id: Long,

    var nome: String,

    var cpfCnpj: String,

    @JsonProperty("data-nascimento")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    var dataNascimento: Date,

    @JsonProperty("endereco")
    var address: Address?
)
