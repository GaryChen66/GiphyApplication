package com.freshworks.giphy

import android.app.Application
import com.freshworks.giphy.modules.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GiphyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GiphyApplication)
            modules(repositoryModule)
        }
    }
}