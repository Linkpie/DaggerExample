package com.example.shared.model

import org.threeten.bp.ZonedDateTime

data class Session(
    val id: String,

    val startTime: ZonedDateTime,

    val endTime: ZonedDateTime,

    val title: String,

    val abstract: String,

    val sessionUrl: String,

    val liveStreamUrl: String,

    val youTubeUrl: String,

    val tags: List<Tag>,

    val speakers: Set<Speaker>,

    val photoUrl: String,

    val relatedSessions: Set<Session>)
