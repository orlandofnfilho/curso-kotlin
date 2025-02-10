package br.com.jofh.usersk_api.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {


    private val log: Logger = LoggerFactory.getLogger(UsersController::class.java)


    @GetMapping("/test")
    fun testController(): ResponseEntity<String> {
        log.info("TESTANDO INFO")
        return ResponseEntity.ok("API Funcionando...")
    }
}