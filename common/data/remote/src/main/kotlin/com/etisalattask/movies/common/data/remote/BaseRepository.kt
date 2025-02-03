package com.etisalattask.movies.common.data.remote

import com.etisalattask.movies.common.data.remote.dto.ErrorResponse
import com.etisalattask.movies.core.Result
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

abstract class BaseRepository {

    /**
     * A generic function to handle API calls, including error handling.
     */
    protected fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Flow<Result<T, String>> {
        return flow {
            emit(Result.Loading())

            try {
                val response = apiCall()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Result.Success(it))
                    } ?: emit(Result.Fail("Empty Response"))
                } else {
                    val errorResponse = parseError(response)
                    emit(Result.Fail(errorResponse ?: "Unknown API Error"))
                }
            } catch (e: Exception) {
                emit(Result.Fail(e.localizedMessage ?: "An unexpected error occurred"))
            }
        }
    }

    /**
     * Parses error response to extract meaningful error messages.
     */
    private fun parseError(response: Response<*>): String? {
        return try {
            val errorBody = response.errorBody()?.string()
            Gson().fromJson(errorBody, ErrorResponse::class.java)?.status_message
        } catch (e: Exception) {
            "Error parsing error response"
        }
    }
}
