package com.ybdevelopers.newsapplication

import android.app.Application
import org.jetbrains.annotations.NotNull
import timber.log.Timber


class ApplicationClass : Application() {


    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(Timber.DebugTree())
        }
    }

    internal class NotLoggingTree : Timber.Tree() {
        override fun log(
            priority: Int,
            tag: String?,
            @NotNull message: String,
            throwable: Throwable?
        ) {
            //log
        }
    }
}