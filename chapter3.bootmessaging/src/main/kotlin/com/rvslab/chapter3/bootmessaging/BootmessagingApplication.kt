package com.rvslab.chapter3.bootmessaging

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootmessagingApplication: CommandLineRunner {
    @Autowired
    private lateinit var sender: Sender

    override fun run(vararg args: String?) {
        sender.send("Hello Messaging..!!!")
    }
}

fun main(args: Array<String>) {
    runApplication<BootmessagingApplication>(*args)
}
