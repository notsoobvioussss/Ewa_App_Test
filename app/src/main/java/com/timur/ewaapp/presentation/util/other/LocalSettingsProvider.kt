package com.timur.ewaapp.presentation.util.ui.other

import androidx.compose.runtime.compositionLocalOf

val LocalSettingsProvider = compositionLocalOf<Settings> { error("Settings not presented") }