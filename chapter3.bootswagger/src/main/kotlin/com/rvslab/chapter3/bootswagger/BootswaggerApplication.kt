package com.rvslab.chapter3.bootswagger

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class BootswaggerApplication

fun main(args: Array<String>) {
    SpringApplication.run(BootswaggerApplication::class.java, *args)
}
