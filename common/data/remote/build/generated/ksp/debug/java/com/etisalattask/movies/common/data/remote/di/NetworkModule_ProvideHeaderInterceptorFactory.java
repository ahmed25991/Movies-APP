package com.etisalattask.movies.common.data.remote.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import okhttp3.Interceptor;

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
public final class NetworkModule_ProvideHeaderInterceptorFactory implements Factory<Interceptor> {
  @Override
  public Interceptor get() {
    return provideHeaderInterceptor();
  }

  public static NetworkModule_ProvideHeaderInterceptorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Interceptor provideHeaderInterceptor() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideHeaderInterceptor());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvideHeaderInterceptorFactory INSTANCE = new NetworkModule_ProvideHeaderInterceptorFactory();
  }
}
