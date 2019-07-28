package com.rvslab.chapter3.bootcustomernotification

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component

@Component
class Mailer @Autowired constructor(var javaMailService: JavaMailSender) {

    fun sendMail(email: String) {
        var mailMessage = SimpleMailMessage()
        mailMessage.setTo(email)
        mailMessage.setSubject("Registration")
        mailMessage.setText("Successfully Registered")
        javaMailService.send(mailMessage)
    }
}