package br.com.jofh.usersk_api.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class UserDTO(
    val nome: String,

    @JsonProperty("data-nascimento")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    val dataNascimento: Date
)
