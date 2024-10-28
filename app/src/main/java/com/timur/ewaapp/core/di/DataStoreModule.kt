package com.timur.ewaapp.core.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.timur.ewaapp.data.repository.SettingsRepositoryImpl
import com.timur.ewaapp.domain.repository.SettingsRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataStoreModule = module {
    singleOf(::SettingsRepositoryImpl) bind SettingsRepository::class
    single<DataStore<Preferences>> {
        PreferenceDataStoreFactory.create(
            produceFile = { androidContext().preferencesDataStoreFile("settings_store") }
        )
    }
}