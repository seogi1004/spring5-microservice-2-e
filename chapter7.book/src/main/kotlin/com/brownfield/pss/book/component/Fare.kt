package com.brownfield.pss.book.component


class Fare {
    var flightNumber: String = ""
    var flightDate: String = ""
    var fare: String = ""
    override fun toString(): String {
        return "Fare [flightNumber=$flightNumber, flightDate=$flightDate, fare=$fare]"
    }

}