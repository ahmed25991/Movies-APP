package com.etisalattask.movies.feature.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etisalattask.movies.common.presentation.state.CommonUiState
import com.etisalattask.movies.core.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import usecase.DisplayMoviesUseCase
import usecase.MovieDetailsUseCase
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesUseCase: DisplayMoviesUseCase,
    private val movieDetailsUseCase: MovieDetailsUseCase,
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


    private val _movieDetailsUiState = MutableStateFlow<CommonUiState>(CommonUiState.Initial)
    val movieDetailsUiState: StateFlow<CommonUiState> = _movieDetailsUiState

    fun fetchMovieDetails(movieId: Int?) {
        viewModelScope.launch {
            movieDetailsUseCase.invoke(movieId=movieId).collect { result ->
                when (result) {
                    is Result.Success -> {
                        _movieDetailsUiState.value = CommonUiState.Content(result.data)
                    }
                    is Result.Loading -> {
                        _movieDetailsUiState.value = CommonUiState.Loading
                    }
                    is Result.Fail -> {
                        _movieDetailsUiState.value = CommonUiState.Fail(
                            errorMessage=result.message)
                    }
                }
            }
        }
    }
}