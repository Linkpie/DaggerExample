package com.example.shared.model

internal interface Tag {
    fun getId(): String

    fun getCategory(): String

    fun getName(): String

    fun getColor(): String
}