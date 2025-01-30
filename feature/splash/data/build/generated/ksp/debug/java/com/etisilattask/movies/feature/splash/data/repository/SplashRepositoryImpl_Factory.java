package com.etisilattask.movies.feature.splash.data.repository;

import com.etisilattask.movies.feature.splash.data.service.SplashService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class SplashRepositoryImpl_Factory implements Factory<SplashRepositoryImpl> {
  private final Provider<SplashService> splashServiceProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public SplashRepositoryImpl_Factory(Provider<SplashService> splashServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.splashServiceProvider = splashServiceProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public SplashRepositoryImpl get() {
    return newInstance(splashServiceProvider.get(), ioDispatcherProvider.get());
  }

  public static SplashRepositoryImpl_Factory create(Provider<SplashService> splashServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new SplashRepositoryImpl_Factory(splashServiceProvider, ioDispatcherProvider);
  }

  public static SplashRepositoryImpl newInstance(SplashService splashService,
      CoroutineDispatcher ioDispatcher) {
    return new SplashRepositoryImpl(splashService, ioDispatcher);
  }
}
