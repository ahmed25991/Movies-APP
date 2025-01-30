package com.etisilattask.movies.feature.splash.data.repository

import com.etisalattask.movies.common.data.remote.di.*
import com.etisalattask.movies.common.data.remote.dto.AppResponse
import com.etisalattask.movies.core.FlowResult
import com.etisalattask.movies.core.Result
import com.etisilattask.movies.feature.splash.data.service.SplashService
import com.google.gson.Gson
import dto.AppConfigModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import repository.SplashRepository
import javax.inject.Inject


class SplashRepositoryImpl @Inject constructor(
    private val splashService: SplashService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : SplashRepository {


    override fun getAppConfigurations(): FlowResult<AppConfigModel, String> =
        flow<Result<AppConfigModel, String>> {
            val response = splashService.getAppConfigurations()
            val body = response.body()
            if (response.isSuccessful) {
                if (body != null && body.status == "success") {
                    emit(Result.Success(body.data))
                }
            } else {
                if (body != null) {
                    val errorResponse = Gson().fromJson(response.errorBody()?.string(), AppResponse::class.java)
                    emit(Result.Fail(errorCode = errorResponse.errorCode.toString(), message = errorResponse.message.toString()))
                }else{
                    emit(Result.Error("INTERNAL_SERVER_ERROR"))
                }
            }
        }.onStart {
            emit(Result.Loading())
        }.catch {
            emit(Result.Error("INTERNAL_SERVER_ERROR"))
        }.flowOn(ioDispatcher)

}


