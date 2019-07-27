package com.rvslab.chapter3.bootwebflux

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class GreetingController {
    @GetMapping("/")
    fun greet() : Mono<Greet> = Mono.just(Greet("Hello World!"))
}

data class Greet(val message: String)