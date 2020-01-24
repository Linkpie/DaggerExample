package com.muhammet.magsumov.dagger.ui

import android.app.Application
import com.example.dagger.BuildConfig
import com.jakewharton.threetenabp.AndroidThreeTen
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //логи
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        //дата и время
        AndroidThreeTen.init(this)
    }

}