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
public final class NetworkModule_ProvideQueryInterceptorFactory implements Factory<Interceptor> {
  @Override
  public Interceptor get() {
    return provideQueryInterceptor();
  }

  public static NetworkModule_ProvideQueryInterceptorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Interceptor provideQueryInterceptor() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideQueryInterceptor());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvideQueryInterceptorFactory INSTANCE = new NetworkModule_ProvideQueryInterceptorFactory();
  }
}
