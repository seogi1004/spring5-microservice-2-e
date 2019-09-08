package com.brownfield.pss.search.repository


import org.springframework.data.jpa.repository.JpaRepository

import com.brownfield.pss.search.entity.Flight

interface FlightRepository : JpaRepository<Flight, Long> {
    fun findByOriginAndDestinationAndFlightDate(origin: String, destination: String, flightDate: String): List<Flight>

    fun findByFlightNumberAndFlightDate(flightNumber: String, flightDate: String): Flight
} 