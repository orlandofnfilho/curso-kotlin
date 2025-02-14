package br.com.jofh.usersk_api.services.impl

import br.com.jofh.usersk_api.entities.User
import br.com.jofh.usersk_api.repositories.UserRepository
import br.com.jofh.usersk_api.services.UserService
import br.com.jofh.usersk_api.web.cep.ViaCepClient
import jakarta.persistence.EntityNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private var userRepository: UserRepository,
    private var viaCepClient: ViaCepClient
) : UserService {

    private val log: Logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override fun saveUser(user: User): User {
        log.debug("Usuário: {}",user)
        user.address = viaCepClient.getAddressByCep(user.address!!.cep)
        return userRepository.save(user)
    }

    override fun findUserByCpfCnpj(cpfCnpj: String): User {
        return userRepository.findByCpfCnpj(cpfCnpj)
            .orElseThrow { EntityNotFoundException("Usuário não encontrado") }
    }


}