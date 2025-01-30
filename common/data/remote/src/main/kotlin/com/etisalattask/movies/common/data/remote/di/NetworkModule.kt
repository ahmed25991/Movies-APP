package com.etisalattask.movies.common.data.remote.di

import com.etisalattask.movies.common.data.remote.util.NetworkConstants.CLIENT_TIME_OUT
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * This module provides the necessary dependencies for network operations,
 * including the configuration of Retrofit, OkHttpClient, and Moshi.
 * It is installed in the SingletonComponent to ensure the same instance is used throughout the app's lifecycle.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {



    /**
     * Provides an instance of [HttpLoggingInterceptor].
     * Used for logging HTTP request and response details.
     * The log level is set to BODY to print complete details.
     *
     * @return an instance of [HttpLoggingInterceptor] for logging HTTP requests and responses.
     */
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level =
                //if (BuildConfig.DEBUG)
        HttpLoggingInterceptor.Level.BODY
            //else
              //  HttpLoggingInterceptor.Level.NONE
        }



    /**
     * Provides a configured [OkHttpClient] instance used by Retrofit.
     * This client includes a logging interceptor for debugging network traffic
     * and a timeout setting for network requests.
     *
     * @param loggingInterceptor the [HttpLoggingInterceptor] for logging HTTP requests and responses.
     * @return a fully configured [OkHttpClient] instance.
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .addInterceptor(loggingInterceptor)
        .build()


    /**
     * Provides a [Retrofit] instance for making API calls.
     * Retrofit is a type-safe HTTP client for Android.
     *
     * @param client the [OkHttpClient] used for network requests.
     * @param moshi the [Moshi] instance for JSON serialization/deserialization.
     * @return a fully configured [Retrofit] instance.
     */
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("")
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()


    /**
     * Provides a [Moshi] instance for converting JSON responses into Kotlin objects.
     * Moshi is a modern JSON library for Android and Java.
     *
     * @return a [Moshi] instance configured with the [KotlinJsonAdapterFactory] for handling Kotlin data classes.
     */
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

}

