package com.etisilattask.movies.feature.splash.presentation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import usecase.SplashUseCase;

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
public final class SplashViewModel_Factory implements Factory<SplashViewModel> {
  private final Provider<SplashUseCase> getSplashUseCaseProvider;

  public SplashViewModel_Factory(Provider<SplashUseCase> getSplashUseCaseProvider) {
    this.getSplashUseCaseProvider = getSplashUseCaseProvider;
  }

  @Override
  public SplashViewModel get() {
    return newInstance(getSplashUseCaseProvider.get());
  }

  public static SplashViewModel_Factory create(Provider<SplashUseCase> getSplashUseCaseProvider) {
    return new SplashViewModel_Factory(getSplashUseCaseProvider);
  }

  public static SplashViewModel newInstance(SplashUseCase getSplashUseCase) {
    return new SplashViewModel(getSplashUseCase);
  }
}
