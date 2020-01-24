package com.muhammet.magsumov.shared.data.session

import com.example.shared.model.Session

object DefaultSessionRepository : SessionRepository(RemoteSessionDataSource)

open class SessionRepository(private val remoteDataSource: SessionDataSource) {

    fun getSessions(): List<Session> {
        return remoteDataSource.getSession()
    }
}