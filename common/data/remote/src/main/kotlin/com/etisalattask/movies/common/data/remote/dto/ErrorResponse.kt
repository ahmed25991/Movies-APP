package com.etisalattask.movies.common.data.remote.dto

data class ErrorResponse(
    val status_code: Int?,
    val status_message: String?,
    val success: Boolean?,
)
