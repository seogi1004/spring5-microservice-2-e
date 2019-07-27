package com.rvslab.chapter3.bootrest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class BootrestApplication

fun main(args: Array<String>) {
    SpringApplication.run(BootrestApplication::class.java, *args)
}
