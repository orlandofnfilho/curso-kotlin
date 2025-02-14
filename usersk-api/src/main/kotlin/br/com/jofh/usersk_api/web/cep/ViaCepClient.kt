package br.com.jofh.usersk_api.web.cep

import br.com.jofh.usersk_api.entities.Address
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "viaCepClient", url = "\${viacep.url}")
interface ViaCepClient {

    @GetMapping("/{cep}/json", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getAddressByCep(@PathVariable cep: String): Address
}