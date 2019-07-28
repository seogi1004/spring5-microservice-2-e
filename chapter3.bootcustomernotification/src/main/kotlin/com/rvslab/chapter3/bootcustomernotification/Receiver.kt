package com.rvslab.chapter3.bootcustomernotification

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class Receiver @Autowired constructor(var mailer : Mailer) {
    @Bean
    fun queue() : Queue = Queue("CustomerQ", false)

    @RabbitListener(queues = [ "CustomerQ" ])
    fun processMessage(email: String) {
        print(email)
        mailer.sendMail(email)
    }
}