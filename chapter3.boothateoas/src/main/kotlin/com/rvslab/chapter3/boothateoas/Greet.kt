package com.rvslab.chapter3.boothateoas

import org.springframework.hateoas.ResourceSupport

class Greet constructor(val message: String) : ResourceSupport() {

}