package com.etisilattask.movies.common.data.remote.localStorage;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class SharedPreferencesManager_Factory implements Factory<SharedPreferencesManager> {
  private final Provider<Context> applicationProvider;

  public SharedPreferencesManager_Factory(Provider<Context> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public SharedPreferencesManager get() {
    return newInstance(applicationProvider.get());
  }

  public static SharedPreferencesManager_Factory create(Provider<Context> applicationProvider) {
    return new SharedPreferencesManager_Factory(applicationProvider);
  }

  public static SharedPreferencesManager newInstance(Context application) {
    return new SharedPreferencesManager(application);
  }
}
