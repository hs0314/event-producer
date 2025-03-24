package me.hs.eventproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventproducerApplication

fun main(args: Array<String>) {
    runApplication<EventproducerApplication>(*args)
}