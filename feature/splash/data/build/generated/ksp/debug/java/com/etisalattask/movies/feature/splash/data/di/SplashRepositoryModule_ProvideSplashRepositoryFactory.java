package com.etisalattask.movies.feature.splash.data.di;

import com.etisilattask.movies.feature.splash.data.service.SplashService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import repository.SplashRepository;

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
public final class SplashRepositoryModule_ProvideSplashRepositoryFactory implements Factory<SplashRepository> {
  private final Provider<SplashService> splashServiceProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public SplashRepositoryModule_ProvideSplashRepositoryFactory(
      Provider<SplashService> splashServiceProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.splashServiceProvider = splashServiceProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public SplashRepository get() {
    return provideSplashRepository(splashServiceProvider.get(), dispatcherProvider.get());
  }

  public static SplashRepositoryModule_ProvideSplashRepositoryFactory create(
      Provider<SplashService> splashServiceProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new SplashRepositoryModule_ProvideSplashRepositoryFactory(splashServiceProvider, dispatcherProvider);
  }

  public static SplashRepository provideSplashRepository(SplashService splashService,
      CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNullFromProvides(SplashRepositoryModule.INSTANCE.provideSplashRepository(splashService, dispatcher));
  }
}
