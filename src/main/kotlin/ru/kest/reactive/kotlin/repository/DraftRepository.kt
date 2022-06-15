package ru.kest.reactive.kotlin.repository

import org.springframework.data.cassandra.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import reactor.core.publisher.Mono
import ru.kest.reactive.kotlin.model.Draft

interface DraftRepository : CoroutineCrudRepository<Draft, Long> {

    @Query("UPDATE drafts SET updated = toTimestamp(now()) WHERE orderid = :orderId")
    suspend fun updateTimestamp(orderId: Long): Mono<Void?>?
}