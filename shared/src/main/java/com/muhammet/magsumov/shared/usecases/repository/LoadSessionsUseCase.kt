package com.muhammet.magsumov.shared.usecases.repository

import com.example.shared.model.Session
import com.muhammet.magsumov.shared.data.session.SessionRepository
import com.muhammet.magsumov.shared.usecases.UseCase

open class LoadSessionsUseCase(private val repository: SessionRepository)  : UseCase<String, List<Session>>() {
    override fun execute(parameters: String): List<Session> {
        Thread.sleep(3000)
        return repository.getSessions()
    }

}