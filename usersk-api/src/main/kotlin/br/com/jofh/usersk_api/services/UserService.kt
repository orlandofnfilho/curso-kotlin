package br.com.jofh.usersk_api.services

import br.com.jofh.usersk_api.entities.User

interface UserService {

    fun saveUser(user: User): User
    fun findUserByCpfCnpj(cpfCnpj: String): User
}