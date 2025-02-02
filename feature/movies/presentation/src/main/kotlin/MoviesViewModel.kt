package com.etisalattask.movies.feature.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etisalattask.movies.common.presentation.state.CommonUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import usecase.DisplayMoviesUseCase
import javax.inject.Inject
import com.etisalattask.movies.core.Result


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesUseCase: DisplayMoviesUseCase
) : ViewModel() {

    private val _moviesUiState = MutableStateFlow<CommonUiState>(CommonUiState.Initial)
    val moviesUiState: StateFlow<CommonUiState> = _moviesUiState

    fun fetchMovies(currentPage:Int?,pageType:String?) {
        viewModelScope.launch {
            moviesUseCase.invoke(currentPage=currentPage,pageType = pageType).collect { result ->
                when (result) {
                    is Result.Success -> {
                        _moviesUiState.value = CommonUiState.Content(result.data)
                    }
                    is Result.Loading -> {
                        _moviesUiState.value = CommonUiState.Loading
                    }
                    is Result.Fail -> {
                        _moviesUiState.value = CommonUiState.Fail(
                            errorMessage=result.message)
                    }
                }
            }
        }
    }
    fun resetDisplayingMovies() { _moviesUiState.value = CommonUiState.Initial }
}