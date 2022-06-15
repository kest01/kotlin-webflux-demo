package ru.kest.reactive.kotlin.service

import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.ThreadLocalRandom
import java.util.stream.Collectors

@Service
class RandomOrderIdService {

    private final val orders: List<Long>

    init {
        RandomOrderIdService::class.java.classLoader.getResourceAsStream("orders.txt").use {
            orders = if (it != null) {
                val reader = BufferedReader(InputStreamReader(it))
                reader.lines()
                    .filter { str: String? -> StringUtils.hasText(str) }
                    .map { s: String? -> s!!.toLong() }
                    .collect(Collectors.toList())
            } else {
                throw RuntimeException("File with orders not found")
            }
        }
    }

    val randomOrderId: Long
        get() = orders[ThreadLocalRandom.current().nextInt(orders.size)]

}
