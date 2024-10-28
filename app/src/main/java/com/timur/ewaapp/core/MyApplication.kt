package com.timur.ewaapp.core

import android.app.Application
import com.timur.ewaapp.core.di.dataModule
import com.timur.ewaapp.core.di.dataStoreModule
import com.timur.ewaapp.core.di.networkModule
import com.timur.ewaapp.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                dataModule,
                dataStoreModule,
                networkModule,
                viewModelModule
            )
        }
    }
}