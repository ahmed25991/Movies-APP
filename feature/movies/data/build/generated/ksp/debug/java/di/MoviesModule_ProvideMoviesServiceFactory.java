package di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;
import service.MoviesService;

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
public final class MoviesModule_ProvideMoviesServiceFactory implements Factory<MoviesService> {
  private final Provider<Retrofit> retrofitProvider;

  public MoviesModule_ProvideMoviesServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MoviesService get() {
    return provideMoviesService(retrofitProvider.get());
  }

  public static MoviesModule_ProvideMoviesServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new MoviesModule_ProvideMoviesServiceFactory(retrofitProvider);
  }

  public static MoviesService provideMoviesService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(MoviesModule.INSTANCE.provideMoviesService(retrofit));
  }
}
