package com.example.shared.model

internal interface Session {

    fun getId(): String


    fun getStartTime(): String


    fun getEndTime(): String


    fun getTitle(): String


    fun getAbstract(): String


    fun getSessionUrl(): String


    fun getLiveStreamUrl(): String


    fun getYouTubeUrl(): String


    fun getTags(): List<Tag>


    fun getSpeakers(): Set<Speaker>


    fun getPhotoUrl(): String


    fun getRelatedSessions(): Set<Session>
}