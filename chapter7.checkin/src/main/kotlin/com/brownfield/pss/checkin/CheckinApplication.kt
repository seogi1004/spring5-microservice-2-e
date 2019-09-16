package com.brownfield.pss.checkin

import java.util.Date

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import com.brownfield.pss.checkin.entity.CheckInRecord
import com.brownfield.pss.checkin.repository.CheckinRepository

@SpringBootApplication
class CheckinApplication : CommandLineRunner {

    @Autowired
    internal var repository: CheckinRepository? = null

    @Throws(Exception::class)
    override fun run(vararg strings: String) {
        val record = CheckInRecord("Franc", "Gean", "28A", Date(), "BF101", "22-JAN-18", 1)

        val result = repository!!.save(record)
        logger.info("checked in successfully ...$result")



        logger.info("Looking to load checkedIn record...")
        logger.info("Result: " + repository!!.findById(result.id))


    }

    companion object {
        private val logger = LoggerFactory.getLogger(CheckinApplication::class.java)

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(CheckinApplication::class.java, *args)
        }
    }
}
