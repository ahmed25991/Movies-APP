package com.etisalattask.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.etisalattask.movies.common.presentation.ui.theme.MoviesAppTheme
import com.etisalattask.movies.navigation.AppNavigation
import com.etisalattask.movies.networkcheckers.ConnectivityObserver
import com.etisalattask.movies.networkcheckers.NoInternetConnectionRoute
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition { isSplashActive }
        super.onCreate(savedInstanceState)
        connectivityObserver = ConnectivityObserver(this)
        connectivityObserver.startMonitoring()
        enableEdgeToEdge()
        setContent {
            MainScreen(connectivityObserver)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        connectivityObserver.stopMonitoring()
    }
}

private var isSplashActive by mutableStateOf(true)
@Composable
fun MainScreen(connectivityObserver: ConnectivityObserver) {
    val isConnected by connectivityObserver.isConnected.collectAsStateWithLifecycle()
    val splashState by rememberUpdatedState(newValue = isSplashActive)
    LaunchedEffect(Unit) {
        delay(2000)
        isSplashActive = false
    }
    MoviesAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            if (!splashState) {
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
