package com.brownfield.pss.client


class SearchQuery {
    var origin: String
    var destination: String
    var flightDate: String

    override fun toString(): String {
        return "SearchQuery [origin=$origin, destination=$destination, flightDate=$flightDate]"
    }

    constructor(origin: String, destination: String, flightDate: String) {
        this.origin = origin
        this.destination = destination
        this.flightDate = flightDate
    }
}