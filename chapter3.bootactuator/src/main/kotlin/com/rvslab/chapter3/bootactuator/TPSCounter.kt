package com.rvslab.chapter3.bootactuator

import java.util.*
import java.util.concurrent.atomic.LongAdder

class TPSCounter {
    private var count: LongAdder = LongAdder()
    private var threshold = 2
    private var expiry: Calendar = Calendar.getInstance()

    constructor() {
        expiry.add(Calendar.MINUTE, 1)
    }

    fun isExpired(): Boolean {
        return Calendar.getInstance().after(expiry)
    }

    fun isWeek(): Boolean {
        return count.toInt() > threshold
    }

    fun increment() {
        count.increment()
    }
}