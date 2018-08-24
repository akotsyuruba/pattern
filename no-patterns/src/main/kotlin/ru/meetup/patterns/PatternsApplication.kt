package ru.meetup.patterns

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PatternsApplication

fun main(args: Array<String>) {
    runApplication<PatternsApplication>(*args)
}
