package ru.kest.reactive.kotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Table
import java.time.Instant

@Table("drafts")
data class Draft(
    @Id
    var orderId: Long = 0,
    val type: String?,
    var updated: Instant? = null
)
