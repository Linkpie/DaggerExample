package com.muhammet.magsumov.dagger.ui.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muhammet.magsumov.shared.data.session.DefaultSessionRepository
import com.muhammet.magsumov.shared.usecases.repository.LoadSessionsUsesCase

@Suppress("UNCHECKED_CAST")
class ScheduleViewModelFactory : ViewModelProvider.Factory {

    private val repository = DefaultSessionRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
            return ScheduleViewModel(LoadSessionsUsesCase(repository)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

