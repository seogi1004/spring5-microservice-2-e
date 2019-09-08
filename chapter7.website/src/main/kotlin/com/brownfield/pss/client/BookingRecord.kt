package com.brownfield.pss.client

import java.util.Date


class BookingRecord {

    var id: Long = 0

    var flightNumber: String? = null
    var origin: String? = null
    var destination: String? = null
    var flightDate: String? = null
    var bookingDate: Date? = null
    var fare: String? = null
    var status: String? = null

    lateinit var passengers: Set<Passenger>

    constructor(flightNumber: String, from: String, to: String,
                flightDate: String, bookingDate: Date, fare: String) {
        this.flightNumber = flightNumber
        this.origin = from
        this.destination = to
        this.flightDate = flightDate
        this.bookingDate = bookingDate
        this.fare = fare
    }

    override fun toString(): String {
        return ("BookingRecord [id=" + id + ", flightNumber=" + flightNumber + ", from=" + origin + ", to=" + destination
                + ", flightDate=" + flightDate + ", bookingDate=" + bookingDate + ", passengers=" + passengers
                + "]")
    }


}
