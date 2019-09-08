package com.brownfield.pss.client


class Fares {
    var id: Long = 0
    var fare: String
    var currency: String

    constructor(fare: String, currency: String) {
        this.fare = fare
        this.currency = currency
    }

    override fun toString(): String {
        return "Fares [id=$id, fare=$fare, currency=$currency]"
    }


}
