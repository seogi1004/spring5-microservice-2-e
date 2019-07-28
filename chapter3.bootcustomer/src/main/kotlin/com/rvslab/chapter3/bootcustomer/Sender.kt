package com.rvslab.chapter3.bootcustomer

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Component
@Lazy
class Sender {
    @Autowired
    private lateinit var template: RabbitMessagingTemplate

    @Bean
    fun queue(): Queue = Queue("CustomerQ", false)

    fun send(message: String) {
        template.convertAndSend("CustomerQ", message)
    }
}