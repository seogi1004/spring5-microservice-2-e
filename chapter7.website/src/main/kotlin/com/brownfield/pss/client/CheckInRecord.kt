package com.brownfield.pss.client

import java.util.Date


class CheckInRecord {
    var id: Long = 0

    var lastName: String
    var firstName: String
    var seatNumber: String
    var checkInTime: Date
    var flightNumber: String
    var flightDate: String
    private var bookingId: Long = 0

    constructor(lastName: String, firstName: String, seatNumber: String, checkInTime: Date, flightNumber: String,
                flightDate: String, bookingId: Long) {
        this.lastName = lastName
        this.firstName = firstName
        this.seatNumber = seatNumber
        this.checkInTime = checkInTime
        this.flightNumber = flightNumber
        this.flightDate = flightDate
        this.bookingId = bookingId
    }

    override fun toString(): String {
        return ("CheckInRecord [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", seatNumber="
                + seatNumber + ", checkInTime=" + checkInTime + ", flightNumber=" + flightNumber + ", flightDate="
                + flightDate + "]")
    }


}
