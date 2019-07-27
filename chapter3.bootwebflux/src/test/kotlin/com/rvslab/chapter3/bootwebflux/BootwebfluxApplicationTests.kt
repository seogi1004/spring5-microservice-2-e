package com.rvslab.chapter3.bootwebflux

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BootwebfluxApplicationTests {
    private lateinit var webClient: WebTestClient

    @Before
    fun setup() {
        webClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8080").build()
    }

    @Test
    fun testWebFluxEndpoint() {
        webClient.get().uri("/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectBody(Greet::class.java).returnResult()
    }
}
