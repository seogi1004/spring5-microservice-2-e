package com.brownfield.pss.search.controller

import java.util.ArrayList
import java.util.Arrays
import java.util.Calendar
import java.util.concurrent.atomic.LongAdder

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.actuate.metrics.GaugeService
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.brownfield.pss.search.component.SearchComponent
import com.brownfield.pss.search.entity.Flight
import org.springframework.beans.factory.annotation.Qualifier

@RefreshScope
@CrossOrigin
@RestController
@RequestMapping("/search")
internal class SearchRestController @Autowired
constructor(private val searchComponent: SearchComponent, @Qualifier("gaugeService") var gaugeService: GaugeService) {
    var tpm = TPMCounter()

    @Value("\${orginairports.shutdown}")
    private val originAirportShutdownList: String? = null

    @RequestMapping(value = ["/get"], method = [RequestMethod.POST])
    fun search(@RequestBody query: SearchQuery): List<Flight> {
        logger.info("Input : $query")
        if (Arrays.asList<String>(*originAirportShutdownList!!.split(",".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()).contains(query.origin)) {
            logger.info("The origin airport is in shutdown state")
            return ArrayList()
        }
        tpm.increment()
        gaugeService.submit("tpm", tpm.count!!.toInt().toDouble())

        return searchComponent.search(query)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SearchComponent::class.java!!)
    }
}


internal class TPMCounter {
    var count: LongAdder? = null
    var expiry: Calendar? = null

    val isExpired: Boolean
        get() = Calendar.getInstance().after(expiry)

    init {
        reset()
    }

    fun reset() {
        count = LongAdder()
        expiry = Calendar.getInstance()
        expiry!!.add(Calendar.MINUTE, 1)
    }


    fun increment() {
        if (isExpired) {
            reset()
        }
        count!!.increment()
    }

}