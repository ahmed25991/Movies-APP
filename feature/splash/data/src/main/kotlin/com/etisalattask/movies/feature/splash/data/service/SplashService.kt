package com.etisilattask.movies.feature.splash.data.service

import com.etisalattask.movies.common.data.remote.dto.AppResponse
import dto.AppConfigModel
import retrofit2.Response
import retrofit2.http.GET


interface SplashService {

    @GET ("configurations")
    suspend fun getAppConfigurations(): Response<AppResponse<AppConfigModel>>
}