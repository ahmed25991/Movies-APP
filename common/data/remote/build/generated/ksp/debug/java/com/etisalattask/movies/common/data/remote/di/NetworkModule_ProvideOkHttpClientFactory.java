package com.etisalattask.movies.common.data.remote.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
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
public final class NetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<HttpLoggingInterceptor> loggingInterceptorProvider;

  private final Provider<Cache> cacheProvider;

  private final Provider<Interceptor> cacheInterceptorProvider;

  private final Provider<Interceptor> headerInterceptorProvider;

  private final Provider<Interceptor> queryInterceptorProvider;

  public NetworkModule_ProvideOkHttpClientFactory(
      Provider<HttpLoggingInterceptor> loggingInterceptorProvider, Provider<Cache> cacheProvider,
      Provider<Interceptor> cacheInterceptorProvider,
      Provider<Interceptor> headerInterceptorProvider,
      Provider<Interceptor> queryInterceptorProvider) {
    this.loggingInterceptorProvider = loggingInterceptorProvider;
    this.cacheProvider = cacheProvider;
    this.cacheInterceptorProvider = cacheInterceptorProvider;
    this.headerInterceptorProvider = headerInterceptorProvider;
    this.queryInterceptorProvider = queryInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient(loggingInterceptorProvider.get(), cacheProvider.get(), cacheInterceptorProvider.get(), headerInterceptorProvider.get(), queryInterceptorProvider.get());
  }

  public static NetworkModule_ProvideOkHttpClientFactory create(
      Provider<HttpLoggingInterceptor> loggingInterceptorProvider, Provider<Cache> cacheProvider,
      Provider<Interceptor> cacheInterceptorProvider,
      Provider<Interceptor> headerInterceptorProvider,
      Provider<Interceptor> queryInterceptorProvider) {
    return new NetworkModule_ProvideOkHttpClientFactory(loggingInterceptorProvider, cacheProvider, cacheInterceptorProvider, headerInterceptorProvider, queryInterceptorProvider);
  }

  public static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor,
      Cache cache, Interceptor cacheInterceptor, Interceptor headerInterceptor,
      Interceptor queryInterceptor) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideOkHttpClient(loggingInterceptor, cache, cacheInterceptor, headerInterceptor, queryInterceptor));
  }
}
