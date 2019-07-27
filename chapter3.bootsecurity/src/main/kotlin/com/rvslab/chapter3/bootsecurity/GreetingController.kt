package com.rvslab.chapter3.bootsecurity

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {
    @GetMapping("/")
    fun greet() : Greet = Greet("Hello World!")
}

data class Greet(val message: String)