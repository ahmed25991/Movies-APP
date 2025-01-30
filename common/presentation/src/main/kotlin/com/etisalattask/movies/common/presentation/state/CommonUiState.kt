package com.etisalattask.movies.common.presentation.state


sealed class CommonUiState {
    data object Initial : CommonUiState()
    data object Loading : CommonUiState()
    data class Content(val model: Any?) : CommonUiState()
    data class Error(val errorMessage: String?) : CommonUiState()
    data class Fail(val errorMessage: String?, val errorCode: String?) : CommonUiState()
}
