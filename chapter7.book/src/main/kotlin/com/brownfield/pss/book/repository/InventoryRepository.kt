package com.brownfield.pss.book.repository


import org.springframework.data.jpa.repository.JpaRepository

import com.brownfield.pss.book.entity.Inventory

interface InventoryRepository : JpaRepository<Inventory, Long> {

    fun findByFlightNumberAndFlightDate(flightNumber: String, flightDate: String): Inventory

}
