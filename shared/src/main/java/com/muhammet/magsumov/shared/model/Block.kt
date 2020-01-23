package com.example.shared.model

import org.threeten.bp.ZonedDateTime

data class Block(

    val title: String,

    val subtitle: String,

    val kind: String,

    val startTime: ZonedDateTime,

    val endTime: ZonedDateTime
)