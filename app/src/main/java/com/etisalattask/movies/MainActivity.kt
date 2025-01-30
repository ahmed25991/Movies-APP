package com.etisalattask.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.etisalattask.movies.common.presentation.ui.theme.MoviesAppTheme
import com.etisalattask.movies.navigation.AppNavigation
import com.etisalattask.movies.networkcheckers.ConnectivityObserver
import com.etisalattask.movies.networkcheckers.NoInternetConnectionRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityObserver = ConnectivityObserver(this)
        connectivityObserver.startMonitoring()
        enableEdgeToEdge()
        setContent {
            val isConnected by connectivityObserver.isConnected.collectAsStateWithLifecycle()
            MoviesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (isConnected) {
                        AppNavigation()
                    } else {
                        NoInternetConnectionRoute(
                            onRetry = { connectivityObserver.startMonitoring() }
                        )
                    }
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        connectivityObserver.stopMonitoring()
    }
}

