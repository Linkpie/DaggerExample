package com.muhammet.magsumov.shared.usecases.internal

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

private const val NUMBER_OF_THREADS = 4

interface Scheduler {

    fun execute(task: () -> Unit)
    fun postToMainThread(task: () -> Unit)
}

object DefaultScheduler : Scheduler {

    private var delegate: Scheduler = AsyncScheduler

    fun setDelegate(newDelegate: Scheduler?) {
        delegate = newDelegate ?: AsyncScheduler
    }

    override fun execute(task: () -> Unit) {
        delegate.execute(task)
    }

    override fun postToMainThread(task: () -> Unit) {
        delegate.postToMainThread(task)
    }

}


internal object AsyncScheduler : Scheduler {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS)
    override fun postToMainThread(task: () -> Unit) {
        if (isMainThread()) {
            task()
        } else {
            val mainThreadHandler = Handler(Looper.getMainLooper())
            mainThreadHandler.post(task)
        }
    }

    override fun execute(task: () -> Unit) {
        executorService.execute(task)
    }

    private fun isMainThread(): Boolean {
        return Looper.getMainLooper().thread === Thread.currentThread()
    }
}

object SyncScheduler : Scheduler {
    override fun execute(task: () -> Unit) {
        task()
    }

    override fun postToMainThread(task: () -> Unit) {
        task()
    }
}