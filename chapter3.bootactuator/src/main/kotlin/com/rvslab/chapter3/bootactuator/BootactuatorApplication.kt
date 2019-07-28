package com.rvslab.chapter3.bootactuator

import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.metrics.CounterService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BootactuatorApplication {
    @Bean
    fun getCounterService(): CounterService {
        return CounterService()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(BootactuatorApplication::class.java, *args)
}
