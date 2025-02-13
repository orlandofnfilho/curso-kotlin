package br.com.jofh.usersk_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["br.com.jofh.usersk_api.repositories"])
@SpringBootApplication
@EnableFeignClients
class UserskApiApplication

fun main(args: Array<String>) {
	runApplication<UserskApiApplication>(*args)
}
