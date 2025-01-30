package com.etisalattask.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.etisilattask.movies.internetUtils.ConnectivityObserver
import com.etisalattask.movies.navigation.AppNavigation
import com.etisilattask.movies.common.presentation.BuildConfig
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, true)

        connectivityObserver = ConnectivityObserver(this)
        connectivityObserver.startMonitoring()
        enableEdgeToEdge()
        BuildConfig
        setContent {
            val isConnected by connectivityObserver.isConnected.collectAsStateWithLifecycle()
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding(),
                color = Color.Transparent
            ) {
                if (isConnected) {
                    AppNavigation()
                } else {
                    NoInternetConnectionRoute()
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        connectivityObserver.stopMonitoring()
    }
}

