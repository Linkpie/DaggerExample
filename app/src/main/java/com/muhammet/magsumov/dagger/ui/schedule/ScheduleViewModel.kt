package com.muhammet.magsumov.dagger.ui.schedule

import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shared.model.Session
import com.muhammet.magsumov.shared.result.Result
import com.muhammet.magsumov.shared.usecases.repository.LoadSessionsUsesCase

class ScheduleViewModel(loadSessionUsesCase: LoadSessionsUsesCase) : ViewModel() {

    private var _sessions = MutableLiveData<List<Session>>()
    private val _isLoading = MutableLiveData<Boolean>().apply { value = true }

    val sessions: LiveData<List<Session>> get() = _sessions
    val isLoading: LiveData<Boolean> get() = _isLoading

    val numberOfSessions = ObservableInt()

    init {
        loadSessionUsesCase.executeAsync("someVar") { result: Result<List<Session>> ->

            when (result) {
                is Result.Success<List<Session>> -> {
                    _sessions.value = result.data
                    numberOfSessions.set(result.data.size)
                    _isLoading.value = false
                }
                is Result.Error -> numberOfSessions.set(0)
                is Result.Loading -> _isLoading.value = true

            }

        }
    }

}