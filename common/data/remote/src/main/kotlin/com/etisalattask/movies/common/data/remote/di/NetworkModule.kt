package com.etisalattask.movies.common.data.remote.di

import android.content.Context
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
import com.etisilattask.movies.common.data.remote.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Cache
import okhttp3.Interceptor
import java.io.File


/**
 * This module provides the necessary dependencies for network operations,
 * including the configuration of Retrofit, OkHttpClient, and Moshi.
 * It is installed in the SingletonComponent to ensure the same instance is used throughout the app's lifecycle.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val CACHE_SIZE_MB = 10L * 1024 * 1024 // 100 MB
    private const val CACHE_MAX_AGE = 60 // 50 minutes


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
            level = if (BuildConfig.DEBUG)
        HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }



    @Provides
    @Singleton
    fun provideCache(@ApplicationContext context: Context): Cache {
        val cacheDir = File(context.cacheDir, "http_cache")
        return Cache(cacheDir, CACHE_SIZE_MB)
    }

    @Provides
    @Singleton
    fun provideCacheInterceptor() = Interceptor { chain ->
        val response = chain.proceed(chain.request())
        response.newBuilder()
            .header("Cache-Control", "public, max-age=$CACHE_MAX_AGE")
            .build()
    }


    @Provides
    @Singleton
    fun provideHeaderInterceptor() = Interceptor { chain ->
        val response = chain.proceed(chain.request())
        response.newBuilder()
            .header("language", "en-US")
            .header("Authorization", BuildConfig.ACCESS_TOKEN)
            .build()
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
        cache: Cache,
        cacheInterceptor: Interceptor,
        headerInterceptor: Interceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .cache(cache)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(headerInterceptor)
        .addNetworkInterceptor(cacheInterceptor) // Use network interceptor for caching
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
        .baseUrl(BuildConfig.BASE_URL)
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

