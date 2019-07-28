package com.rvslab.chapter3.bootactuator

import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component

@Component
class TPSHealth : HealthIndicator {
    private var counter: TPSCounter? = null

    override fun health(): Health {
        var health = counter!!.isWeek()

        if(health) {
            return Health.outOfService()
                    .withDetail("Too many request", "OutofService")
                    .build()
        }
        return Health.up().build()
    }

    fun updateTx() {
        if(counter == null || counter!!.isExpired()) {
            counter = TPSCounter()
        }
        counter!!.increment()
    }
}