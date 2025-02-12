package br.com.jofh.usersk_api.services.impl

import br.com.jofh.usersk_api.entities.User
import br.com.jofh.usersk_api.repositories.UserRepository
import br.com.jofh.usersk_api.services.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(private val userRepository: UserRepository): UserService {
    override fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    override fun findUserByCpfCnpj(cpfCnpj: String): Optional<User> {
        TODO("Not yet implemented")
    }


}