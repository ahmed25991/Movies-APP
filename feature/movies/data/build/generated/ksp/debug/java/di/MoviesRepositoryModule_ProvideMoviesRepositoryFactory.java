package di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import repo.MoviesRepository;
import service.MoviesService;

@ScopeMetadata("dagger.hilt.android.scopes.ViewModelScoped")
@QualifierMetadata("com.etisalattask.movies.common.data.remote.di.IoDispatcher")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class MoviesRepositoryModule_ProvideMoviesRepositoryFactory implements Factory<MoviesRepository> {
  private final Provider<MoviesService> moviesServiceProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public MoviesRepositoryModule_ProvideMoviesRepositoryFactory(
      Provider<MoviesService> moviesServiceProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.moviesServiceProvider = moviesServiceProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public MoviesRepository get() {
    return provideMoviesRepository(moviesServiceProvider.get(), dispatcherProvider.get());
  }

  public static MoviesRepositoryModule_ProvideMoviesRepositoryFactory create(
      Provider<MoviesService> moviesServiceProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new MoviesRepositoryModule_ProvideMoviesRepositoryFactory(moviesServiceProvider, dispatcherProvider);
  }

  public static MoviesRepository provideMoviesRepository(MoviesService moviesService,
      CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNullFromProvides(MoviesRepositoryModule.INSTANCE.provideMoviesRepository(moviesService, dispatcher));
  }
}
