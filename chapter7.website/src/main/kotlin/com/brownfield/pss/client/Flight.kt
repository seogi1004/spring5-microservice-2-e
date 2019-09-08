package com.brownfield.pss.client


class Flight {
    var id: Long = 0
    var flightNumber: String
    var origin: String
    var destination: String
    var flightDate: String

    var fares: Fares

    constructor(flightNumber: String, origin: String, destination: String, flightDate: String, fares: Fares) {
        this.flightNumber = flightNumber
        this.origin = origin
        this.destination = destination
        this.flightDate = flightDate
        this.fares = fares
    }

    override fun toString(): String {
        return ("Flight [id=" + id + ", flightNUmber=" + flightNumber + ", origin=" + origin + ", destination="
                + destination + ", flightDate=" + flightDate + ", fares=" + fares + "]")
    }


}
