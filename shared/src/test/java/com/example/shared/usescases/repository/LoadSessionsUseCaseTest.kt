package com.example.shared.usescases.repository

import com.example.shared.model.Session
import com.muhammet.magsumov.shared.data.session.DefaultSessionRepository
import com.muhammet.magsumov.shared.result.Result
import com.muhammet.magsumov.shared.usecases.repository.LoadSessionsUseCase
import junit.framework.Assert.assertEquals
import org.junit.Test

class LoadSessionsUseCaseTest{

    @Test
    fun returnsListOfSessions(){
        val loadSessionsUseCase = LoadSessionsUseCase(DefaultSessionRepository)
        val sessions:Result.Success<List<Session>> = loadSessionsUseCase.executeNow("test")
                as Result.Success<List<Session>>

        assertEquals(sessions.data, DefaultSessionRepository.getSessions())
    }
}