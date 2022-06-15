package ru.kest.reactive.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinWebfluxDemoApplication

fun main(args: Array<String>) {
	runApplication<KotlinWebfluxDemoApplication>(*args)
}
