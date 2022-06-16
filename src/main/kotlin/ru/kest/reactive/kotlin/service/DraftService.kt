package ru.kest.reactive.kotlin.service

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import ru.kest.reactive.kotlin.repository.DraftRepository
import java.time.Instant

private val log = KotlinLogging.logger {}

@Service
class DraftService(val draftRepository: DraftRepository) {

    suspend fun updateDraft(orderId: Long) : String {
        val draft = draftRepository.findById(orderId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Draft not found")

        draft.updated = Instant.now()
        draftRepository.save(draft)
        draftRepository.updateTimestamp(orderId)

        return orderId.toString()
    }

}




/*    suspend fun updateDraft(orderId: Long) : String {
        log.info { "updateDraft($orderId)" }
        val draft = draftRepository.findById(orderId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Draft not found")
        log.info { "## updateDraft 1" }
        draft.updated = Instant.now()
        draftRepository.save(draft)
        log.info { "## updateDraft 2" }
        draftRepository.updateTimestamp(orderId)

        log.info { "draft $orderId successfully updated" }

        return orderId.toString()
    }
*/