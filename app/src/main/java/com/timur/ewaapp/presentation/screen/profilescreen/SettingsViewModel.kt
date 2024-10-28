package com.timur.ewaapp.presentation.screen.profilescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timur.ewaapp.domain.repository.SettingsRepository
import com.timur.ewaapp.presentation.util.ui.other.HeadlineOverflowBehaviour
import com.t8rin.dynamic.theme.ColorTuple
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    fun updateAmoledMode(enabled: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.updateAmoledMode(enabled)
        }
    }

    fun updateUseDarkMode(enabled: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.updateIsDarkMode(enabled)
        }
    }

    fun updateUseBorders(enabled: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.updateBordersEnabled(enabled)
        }
    }

    fun updateUseDynamicColors(enabled: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.updateUseDynamicColors(enabled)
        }
    }

    fun updateColorTuple(colors: ColorTuple) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.updateColorTuple(colors)
        }
    }

    fun updateOverflowBehaviour(value: HeadlineOverflowBehaviour) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.updateHeadlineOverflowBehaviour(value)
        }
    }
}