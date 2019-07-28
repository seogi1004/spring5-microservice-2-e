package com.rvslab.chapter3.bootcustomer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "customers")
interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findByName(@Param("name") name: String) : Customer?
}