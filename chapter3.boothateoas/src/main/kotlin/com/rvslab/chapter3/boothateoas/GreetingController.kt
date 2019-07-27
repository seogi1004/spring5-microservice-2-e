package com.rvslab.chapter3.boothateoas

import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {
    @RequestMapping("/greeting")
    @ResponseBody
    fun greeting(@RequestParam(value = "name", required = false, defaultValue = "HATEOAS") name: String): HttpEntity<Greet> {
        val greet = Greet("Hello $name")
        greet.add(linkTo(
                methodOn(GreetingController::class.java)
                        .greeting(name))
                .withSelfRel()
        )
        return ResponseEntity<Greet>(greet, HttpStatus.OK)
    }
}