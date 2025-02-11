package br.com.jofh.usersk_api.repositories

import br.com.jofh.usersk_api.entities.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository: JpaRepository<Address, Long?>{
}