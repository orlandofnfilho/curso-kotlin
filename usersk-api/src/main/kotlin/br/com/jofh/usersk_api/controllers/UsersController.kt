package br.com.jofh.usersk_api.controllers

import br.com.jofh.usersk_api.dtos.UserDTO
import br.com.jofh.usersk_api.dtos.toDTO
import br.com.jofh.usersk_api.dtos.toDomain
import br.com.jofh.usersk_api.services.UserService
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UsersController(val userService: UserService) {


    private val log: Logger = LoggerFactory.getLogger(UsersController::class.java)

    @PostMapping
    fun saveUser(@RequestBody @Valid requestDTO: UserDTO ): ResponseEntity<UserDTO>{
        return ResponseEntity.ok(userService.saveUser(requestDTO.toDomain()).toDTO());
    }

    @GetMapping("/{cpfCnpj}")
    fun findByCpfCnpj(@PathVariable cpfCnpj: String): ResponseEntity<String> {
        log.debug("CHEGOU AQUI")
        return ResponseEntity.ok("CPFCNPJ: "+ cpfCnpj)
    }
}