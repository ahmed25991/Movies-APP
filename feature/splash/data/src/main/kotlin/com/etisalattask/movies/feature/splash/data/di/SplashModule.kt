package com.etisalattask.movies.feature.splash.data.di

import com.etisilattask.movies.feature.splash.data.service.SplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SplashModule {

    @Provides
    @Singleton
    fun provideSplashService(retrofit: Retrofit): SplashService = retrofit.create(SplashService::class.java)

}