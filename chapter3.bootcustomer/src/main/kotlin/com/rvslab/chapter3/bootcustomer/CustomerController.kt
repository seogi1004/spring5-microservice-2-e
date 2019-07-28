package com.rvslab.chapter3.bootcustomer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerRegistrar: CustomerRegistrar

    @PostMapping(path=["/register"])
    fun register(@RequestBody customer: Customer): Mono<Customer> {
        return customerRegistrar.register(customer)
    }
}