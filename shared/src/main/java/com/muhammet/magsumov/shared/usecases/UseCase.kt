package com.muhammet.magsumov.shared.usecases

import com.muhammet.magsumov.shared.usecases.internal.DefaultScheduler
import com.muhammet.magsumov.shared.result.Result
import timber.log.Timber
import java.lang.ref.WeakReference

abstract class UseCase<in P, out R> {

    private val taskScheduler = DefaultScheduler

    /* The callback is stored with a weak reference to prevent leaks. */
    private lateinit var callback: WeakReference<(Result<R>) -> Any>

    fun executeAsync(parameters: P, callback: (Result<R>) -> Any) {
        this.callback = WeakReference(callback)

        taskScheduler.execute {
            try {
                execute(parameters)?.let {
                    notifyResult(it)
                } ?: notifyError(NullPointerException("Result was null"))
            } catch (error: Exception) {
                Timber.d(error)
                notifyError(error)
            }
        }
    }

    /** Executes the use case synchronously  */
    fun executeNow(parameters: P): Result<R> {
        return try {
            Result.Success(execute(parameters))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    private fun notifyResult(result: R) {
        callback.get()?.let {
            taskScheduler.postToMainThread {
                val safeCallback: (Result<R>) -> Any = callback.get() ?: return@postToMainThread
                safeCallback(Result.Success(result))
            }
        }
    }

    private fun notifyError(exception: Exception) {
        callback.get()?.let {
            taskScheduler.postToMainThread {
                val safeCallback: (Result<R>) -> Any = callback.get() ?: return@postToMainThread
                safeCallback(Result.Error(exception))
            }
        }
    }


    @Throws(RuntimeException::class)
    protected abstract fun execute(parameters: P): R

}
