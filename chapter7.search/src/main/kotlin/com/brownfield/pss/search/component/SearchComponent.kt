package com.brownfield.pss.search.component

import java.util.ArrayList

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.brownfield.pss.search.controller.SearchQuery
import com.brownfield.pss.search.entity.Flight
import com.brownfield.pss.search.entity.Inventory
import com.brownfield.pss.search.repository.FlightRepository

@Component
class SearchComponent @Autowired
constructor(private val flightRepository: FlightRepository) {

    fun search(query: SearchQuery): List<Flight> {
        val flights = flightRepository.findByOriginAndDestinationAndFlightDate(query.origin,
                query.destination,
                query.flightDate)
        val searchResult = ArrayList<Flight>()
        searchResult.addAll(flights)
        flights.forEach { flight ->
            flight.fares
            val inv = flight.inventory.count
            if (inv < 0) {
                searchResult.remove(flight)
            }
        }
        return searchResult
    }

    fun updateInventory(flightNumber: String, flightDate: String, inventory: Int) {
        logger.info("Updating inventory for flight $flightNumber innventory $inventory")
        val flight = flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate)
        val inv = flight.inventory
        inv.count = inventory
        flightRepository.save(flight)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SearchComponent::class.java!!)
    }
}
