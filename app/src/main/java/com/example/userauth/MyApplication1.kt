package com.example.userauth

import android.app.Application
import org.koin.android.java.KoinAndroidApplication
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        val koin = KoinAndroidApplication.create(this)
            .modules(appModule)
        startKoin(koin)
    }
}