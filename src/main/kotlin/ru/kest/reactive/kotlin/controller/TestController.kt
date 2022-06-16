package ru.kest.reactive.kotlin.controller

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.kest.reactive.kotlin.service.DraftService
import ru.kest.reactive.kotlin.service.RandomOrderIdService

private val log = KotlinLogging.logger {}

@RestController
@RequestMapping("/test")
class TestController(val draftService: DraftService,
                     val randomOrderIdService: RandomOrderIdService) {

    @GetMapping("/update")
    suspend fun update(): String {
        log.info { "Start update request" }
        return draftService.updateDraft(randomOrderIdService.randomOrderId)
    }


}