package br.com.jofh.usersk_api.services.impl

import br.com.jofh.usersk_api.entities.User
import br.com.jofh.usersk_api.repositories.UserRepository
import br.com.jofh.usersk_api.services.UserService
import br.com.jofh.usersk_api.web.cep.ViaCepClient
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private var userRepository: UserRepository,
    private var viaCepClient: ViaCepClient
) : UserService {

    private val log: Logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

    @Transactional
    override fun saveUser(user: User): User {
        log.debug("Usuário: {}",user)
        user.address = viaCepClient.getAddressByCep(user.address!!.cep)
        return userRepository.save(user)
    }

    override fun findUserByCpfCnpj(cpfCnpj: String): User {
        return userRepository.findByCpfCnpj(cpfCnpj)
            .orElseThrow { EntityNotFoundException("Usuário não encontrado") }
    }

    @Transactional
    override fun updateUser(user: User): User {
        val existentUser = this.findUserByCpfCnpj(user.cpfCnpj)
        user.id = existentUser.id
        user.address = viaCepClient.getAddressByCep(user.address!!.cep)
        return userRepository.save(user)
    }

    @Transactional
    override fun deleteUser(cpfCnpj: String) {
        val user = this.userRepository.findByCpfCnpj(cpfCnpj).get();
        userRepository.delete(user);
    }


}