package br.com.jofh.usersk_api.controllers

import br.com.jofh.usersk_api.dtos.UserRequest
import br.com.jofh.usersk_api.dtos.UserResponse
import br.com.jofh.usersk_api.dtos.toDomain
import br.com.jofh.usersk_api.dtos.toResponse
import br.com.jofh.usersk_api.services.UserService
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UsersController(private val userService: UserService) {


    private val log: Logger = LoggerFactory.getLogger(UsersController::class.java)

    @PostMapping
    fun saveUser(@RequestBody @Valid requestDTO: UserRequest ): ResponseEntity<UserResponse>{
        return ResponseEntity.ok(userService.saveUser(requestDTO.toDomain()).toResponse());
    }

    @GetMapping("/{cpfCnpj}")
    fun findByCpfCnpj(@PathVariable cpfCnpj: String): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.findUserByCpfCnpj(cpfCnpj).toResponse());
    }

    @PutMapping
    fun updateUser(@RequestBody @Valid requestDTO: UserRequest ): ResponseEntity<UserResponse>{
        return ResponseEntity.ok(userService.updateUser(requestDTO.toDomain()).toResponse());
    }

    @DeleteMapping("/{cpfCnpj}")
    fun deleteUser(@PathVariable cpfCnpj: String): ResponseEntity<Unit> {
        userService.deleteUser(cpfCnpj);
        return ResponseEntity.noContent().build();
    }
}