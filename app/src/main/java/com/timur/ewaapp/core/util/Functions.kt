package com.timur.ewaapp.core.util

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.timur.ewaapp.R

fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
    return when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        else -> false
    }
}

@Composable
fun NoInternetDialog(onRetry: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Button(shape = RoundedCornerShape(15.dp), onClick = { onRetry() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)) {
                Text(stringResource(R.string.retry))
            }
        },
        title = {
            Text(stringResource( R.string.no_internet))
        },
        text = {
            Text(stringResource(R.string.try_again))
        }
    )
}