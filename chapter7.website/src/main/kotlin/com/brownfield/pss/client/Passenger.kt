package com.brownfield.pss.client


import com.fasterxml.jackson.annotation.JsonIgnore


class Passenger {
    var id: Long = 0
    var firstName: String = ""
    var lastName: String = ""
    var gender: String = ""

    @JsonIgnore
    var bookingRecord: BookingRecord? = null

    constructor() {
    }

    constructor(firstName: String, lastName: String, gender: String, bookingRecord: BookingRecord) {
        this.firstName = firstName
        this.lastName = lastName
        this.gender = gender
        this.bookingRecord = bookingRecord
    }

    override fun toString(): String {
        return "Passenger [id=$id, firstName=$firstName, lastName=$lastName, gender=$gender]"
    }


}
