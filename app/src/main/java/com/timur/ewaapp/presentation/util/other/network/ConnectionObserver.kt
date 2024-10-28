package com.timur.ewaapp.presentation.util.ui.other.network

import kotlinx.coroutines.flow.Flow

interface ConnectionObserver {
    fun observe(): Flow<NetworkStatus>
}