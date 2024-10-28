package com.timur.ewaapp.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.timur.ewaapp.core.util.NoInternetDialog
import com.timur.ewaapp.core.util.isInternetAvailable
import com.timur.ewaapp.presentation.util.ui.other.LocalSettingsProvider
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import org.koin.android.ext.android.inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            var showApp by remember { mutableStateOf(false) }
            var isNetworkAvailable by remember { mutableStateOf(true) }
            isNetworkAvailable = isInternetAvailable(this@MainActivity)
            if(isNetworkAvailable) {
                CompositionLocalProvider(
                    LocalSettingsProvider provides viewModel.settings
                ) {
                    rememberSystemUiController().setSystemBarsColor(
                        Color.Transparent,
                        isNavigationBarContrastEnforced = false
                    )
                    MyApp(viewModel)
                }
            }
            else{
                NoInternetDialog(onRetry = {
                    isNetworkAvailable = isInternetAvailable(this)
                    if (isNetworkAvailable) {
                        showApp = true
                    }
                })
            }
        }
    }
}