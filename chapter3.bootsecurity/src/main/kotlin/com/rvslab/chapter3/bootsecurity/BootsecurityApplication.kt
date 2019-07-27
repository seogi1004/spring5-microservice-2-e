package com.rvslab.chapter3.bootsecurity

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
class BootsecurityApplication

fun main(args: Array<String>) {
    SpringApplication.run(BootsecurityApplication::class.java, *args)
}
