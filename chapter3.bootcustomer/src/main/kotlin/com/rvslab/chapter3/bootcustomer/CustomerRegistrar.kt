package com.rvslab.chapter3.bootcustomer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
@Lazy
class CustomerRegistrar @Autowired constructor(var customerRepository: CustomerRepository, var sender: Sender) {
    fun register(customer: Customer): Mono<Customer> {
        if(customerRepository.findByName(customer.name) != null) {
            print("Duplicate Customer. No Action required.")
        } else {
            customerRepository.save(customer)
            sender.send(customer.email)
        }
        return Mono.just(customer)
    }
}