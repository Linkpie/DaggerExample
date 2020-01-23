package com.example.shared.model

internal interface Block {

    fun getTitle(): String

    fun getSubtitle(): String

    fun getKind(): String

    fun getStartTime(): Long

    fun getEndTime(): Long
}