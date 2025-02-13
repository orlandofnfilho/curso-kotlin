package br.com.jofh.usersk_api.repositories

import br.com.jofh.usersk_api.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, Long?>{
    fun findByCpfCnpj(cpfCnpj: String): Optional<User>
}
