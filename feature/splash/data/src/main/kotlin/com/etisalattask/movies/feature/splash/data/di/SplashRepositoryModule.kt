package com.etisalattask.movies.feature.splash.data.di

import com.etisalattask.movies.common.data.remote.di.IoDispatcher
import com.etisilattask.movies.feature.splash.data.repository.SplashRepositoryImpl
import com.etisilattask.movies.feature.splash.data.service.SplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import repository.SplashRepository


@Module
@InstallIn(ViewModelComponent::class)
object SplashRepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideSplashRepository(
        splashService: SplashService,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): SplashRepository {
        return SplashRepositoryImpl(splashService,
            dispatcher)
    }
}
