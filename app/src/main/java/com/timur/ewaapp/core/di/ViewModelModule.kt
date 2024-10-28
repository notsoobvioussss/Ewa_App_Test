package com.timur.ewaapp.core.di

import com.timur.ewaapp.presentation.activity.MainViewModel
import com.timur.ewaapp.presentation.screen.characters.CharacterViewModel
import com.timur.ewaapp.presentation.screen.profilescreen.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel {SettingsViewModel(get())}
}