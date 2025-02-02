package repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import service.MoviesService;

@ScopeMetadata
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
public final class MoviesRepositoryImpl_Factory implements Factory<MoviesRepositoryImpl> {
  private final Provider<MoviesService> moviesServiceProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public MoviesRepositoryImpl_Factory(Provider<MoviesService> moviesServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.moviesServiceProvider = moviesServiceProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public MoviesRepositoryImpl get() {
    return newInstance(moviesServiceProvider.get(), ioDispatcherProvider.get());
  }

  public static MoviesRepositoryImpl_Factory create(Provider<MoviesService> moviesServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new MoviesRepositoryImpl_Factory(moviesServiceProvider, ioDispatcherProvider);
  }

  public static MoviesRepositoryImpl newInstance(MoviesService moviesService,
      CoroutineDispatcher ioDispatcher) {
    return new MoviesRepositoryImpl(moviesService, ioDispatcher);
  }
}
