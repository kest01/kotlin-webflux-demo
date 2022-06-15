package ru.kest.reactive.kotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.kest.reactive.kotlin.service.DraftService
import ru.kest.reactive.kotlin.service.RandomOrderIdService

@RestController
@RequestMapping("/test")
class TestController(val draftService: DraftService,
                     val randomOrderIdService: RandomOrderIdService) {

    @GetMapping("/update")
    suspend fun update(): String =
        draftService.updateDraft(randomOrderIdService.randomOrderId)

}