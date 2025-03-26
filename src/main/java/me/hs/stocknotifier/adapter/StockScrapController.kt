package me.hs.eventproducer.adapter

import me.hs.eventproducer.application.StockSummaryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class StockScrapController(
        private val stockSummaryService: StockSummaryService
) {

}