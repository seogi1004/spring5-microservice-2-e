package com.rvslab.chapter3.bootmessaging

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class Sender {
    @Autowired
    private lateinit var template: RabbitMessagingTemplate

    @Bean
    fun queue(): Queue = Queue("TestQ", false)

    fun send(message: String) {
        template.convertAndSend("TestQ", message)
    }
}