package br.com.jofh.usersk_api.web.config

import feign.Response
import feign.codec.ErrorDecoder
import org.slf4j.LoggerFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors

class FeignErrorDecoder : ErrorDecoder {
    private val logger = LoggerFactory.getLogger(FeignErrorDecoder::class.java)
    private val defaultErrorDecoder = ErrorDecoder.Default()

    override fun decode(methodKey: String?, response: Response?): Exception {
        var body: String? = null
        response?.body()?.let {
            try {
                BufferedReader(InputStreamReader(it.asInputStream(), StandardCharsets.UTF_8)).use { reader ->
                    body = reader.lines().collect(Collectors.joining(System.lineSeparator()))
                }
            } catch (e: IOException) {
                logger.error("Error reading response body", e)
            }
        }
        logger.error("Feign error during call to {}: status code {}, body: {}", methodKey, response?.status(), body)
        return defaultErrorDecoder.decode(methodKey, response)
    }
}