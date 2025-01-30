package com.etisalattask.movies.feature.splash.data.di;

import com.etisilattask.movies.feature.splash.data.service.SplashService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class SplashModule_ProvideSplashServiceFactory implements Factory<SplashService> {
  private final Provider<Retrofit> retrofitProvider;

  public SplashModule_ProvideSplashServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public SplashService get() {
    return provideSplashService(retrofitProvider.get());
  }

  public static SplashModule_ProvideSplashServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new SplashModule_ProvideSplashServiceFactory(retrofitProvider);
  }

  public static SplashService provideSplashService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(SplashModule.INSTANCE.provideSplashService(retrofit));
  }
}
