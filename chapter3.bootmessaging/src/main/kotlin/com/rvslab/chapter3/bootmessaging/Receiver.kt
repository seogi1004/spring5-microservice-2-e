package com.rvslab.chapter3.bootmessaging

import org.springframework.amqp.rabbit.annotation.RabbitListener

class Receiver {
    @RabbitListener(queues = [ "TestQ" ])
    fun processMessage(content: String) {
        print(content)
    }
}