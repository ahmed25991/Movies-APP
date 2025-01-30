package com.etisalattask.movies.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppResponse<T>(
    val status: String,
    val data: T?=null,
    val message: String?=null,
    val errorCode: String?=null
)

