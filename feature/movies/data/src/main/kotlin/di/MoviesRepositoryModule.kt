package di

import com.etisalattask.movies.common.data.remote.di.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import repo.MoviesRepository
import repository.MoviesRepositoryImpl
import service.MoviesService


@Module
@InstallIn(ViewModelComponent::class)
object MoviesRepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMoviesRepository(
        moviesService: MoviesService,
        @IoDispatcher dispatcher: CoroutineDispatcher): MoviesRepository = MoviesRepositoryImpl(moviesService, dispatcher)

}