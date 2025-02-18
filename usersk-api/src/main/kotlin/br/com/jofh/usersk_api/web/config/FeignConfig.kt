package br.com.jofh.usersk_api.web.config

import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FeignConfig {

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return FeignErrorDecoder()
    }
}
