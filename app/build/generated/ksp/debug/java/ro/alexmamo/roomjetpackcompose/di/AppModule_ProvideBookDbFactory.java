package ro.alexmamo.roomjetpackcompose.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import ro.alexmamo.roomjetpackcompose.data.network.BookDb;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class AppModule_ProvideBookDbFactory implements Factory<BookDb> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideBookDbFactory(AppModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public BookDb get() {
    return provideBookDb(module, contextProvider.get());
  }

  public static AppModule_ProvideBookDbFactory create(AppModule module,
      javax.inject.Provider<Context> contextProvider) {
    return new AppModule_ProvideBookDbFactory(module, Providers.asDaggerProvider(contextProvider));
  }

  public static AppModule_ProvideBookDbFactory create(AppModule module,
      Provider<Context> contextProvider) {
    return new AppModule_ProvideBookDbFactory(module, contextProvider);
  }

  public static BookDb provideBookDb(AppModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideBookDb(context));
  }
}
