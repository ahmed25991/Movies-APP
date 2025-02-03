package com.etisalattask.movies.feature.movies.presentation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import usecase.DisplayMoviesUseCase;
import usecase.MovieDetailsUseCase;

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

  private final Provider<MovieDetailsUseCase> movieDetailsUseCaseProvider;

  public MoviesViewModel_Factory(Provider<DisplayMoviesUseCase> moviesUseCaseProvider,
      Provider<MovieDetailsUseCase> movieDetailsUseCaseProvider) {
    this.moviesUseCaseProvider = moviesUseCaseProvider;
    this.movieDetailsUseCaseProvider = movieDetailsUseCaseProvider;
  }

  @Override
  public MoviesViewModel get() {
    return newInstance(moviesUseCaseProvider.get(), movieDetailsUseCaseProvider.get());
  }

  public static MoviesViewModel_Factory create(Provider<DisplayMoviesUseCase> moviesUseCaseProvider,
      Provider<MovieDetailsUseCase> movieDetailsUseCaseProvider) {
    return new MoviesViewModel_Factory(moviesUseCaseProvider, movieDetailsUseCaseProvider);
  }

  public static MoviesViewModel newInstance(DisplayMoviesUseCase moviesUseCase,
      MovieDetailsUseCase movieDetailsUseCase) {
    return new MoviesViewModel(moviesUseCase, movieDetailsUseCase);
  }
}
