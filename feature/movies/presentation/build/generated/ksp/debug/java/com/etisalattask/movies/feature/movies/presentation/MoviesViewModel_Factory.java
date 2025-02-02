package com.etisalattask.movies.feature.movies.presentation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import usecase.DisplayMoviesUseCase;

@ScopeMetadata
@QualifierMetadata
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
public final class MoviesViewModel_Factory implements Factory<MoviesViewModel> {
  private final Provider<DisplayMoviesUseCase> moviesUseCaseProvider;

  public MoviesViewModel_Factory(Provider<DisplayMoviesUseCase> moviesUseCaseProvider) {
    this.moviesUseCaseProvider = moviesUseCaseProvider;
  }

  @Override
  public MoviesViewModel get() {
    return newInstance(moviesUseCaseProvider.get());
  }

  public static MoviesViewModel_Factory create(
      Provider<DisplayMoviesUseCase> moviesUseCaseProvider) {
    return new MoviesViewModel_Factory(moviesUseCaseProvider);
  }

  public static MoviesViewModel newInstance(DisplayMoviesUseCase moviesUseCase) {
    return new MoviesViewModel(moviesUseCase);
  }
}
