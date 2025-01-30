package com.etisilattask.movies.feature.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etisalattask.movies.common.presentation.state.CommonUiState
import com.etisalattask.movies.core.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import usecase.SplashUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getSplashUseCase: SplashUseCase) : ViewModel() {

    private val _splashUiState = MutableStateFlow<CommonUiState>(CommonUiState.Loading)
    val splashUiState: StateFlow<CommonUiState> = _splashUiState

    init { fetchAppConfigs() }

    private fun fetchAppConfigs() {

        viewModelScope.launch {
            getSplashUseCase.invoke().collect { result ->
                when (result) {
                    is Result.Success -> {
                        _splashUiState.value = CommonUiState.Content(result.data)
                    }
                    is Result.Loading -> {
                        _splashUiState.value = CommonUiState.Loading
                    }
                    is Result.Error -> {
                        _splashUiState.value = CommonUiState.Error(result.error)
                    }
                    is Result.Fail -> {
                        _splashUiState.value = CommonUiState.Fail(result.errorCode, result.message)
                    }
                }
            }
        }
    }
}