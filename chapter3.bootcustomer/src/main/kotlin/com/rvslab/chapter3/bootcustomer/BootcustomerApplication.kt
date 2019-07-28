package com.rvslab.chapter3.bootcustomer

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BootcustomerApplication {
    @Bean
    fun init(repo: CustomerRepository): CommandLineRunner {
        return CommandLineRunner {
            repo.save(Customer("Adam", "adam@boot.com"))
            repo.save(Customer("John", "john@boot.com"))
            repo.save(Customer("Smith", "smith@boot.com"))
            repo.save(Customer("Edgar", "edgar@boot.com"))
            repo.save(Customer("Tom", "tom@boot.com"))
            repo.save(Customer("Sean", "sean@boot.com"))
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(BootcustomerApplication::class.java, *args)
}
