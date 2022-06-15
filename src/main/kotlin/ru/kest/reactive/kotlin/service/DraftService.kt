package ru.kest.reactive.kotlin.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import ru.kest.reactive.kotlin.repository.DraftRepository
import java.time.Instant

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