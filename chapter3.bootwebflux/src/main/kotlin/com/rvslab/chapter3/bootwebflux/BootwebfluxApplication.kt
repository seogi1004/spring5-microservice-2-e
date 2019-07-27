package com.rvslab.chapter3.bootwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootwebfluxApplication

fun main(args: Array<String>) {
    runApplication<BootwebfluxApplication>(*args)
}
