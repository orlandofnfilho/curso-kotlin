package br.com.jofh.usersk_api.services

import br.com.jofh.usersk_api.entities.User
import java.util.Optional

interface UserService {

    fun saveUser(user: User): User
    fun findUserByCpfCnpj(cpfCnpj: String): Optional<User>
}