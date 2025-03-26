package me.hs.eventproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StocknotifierApplication

fun main(args: Array<String>) {
    runApplication<StocknotifierApplication>(*args)
}