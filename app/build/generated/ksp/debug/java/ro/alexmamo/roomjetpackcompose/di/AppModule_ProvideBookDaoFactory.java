package ro.alexmamo.roomjetpackcompose.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import ro.alexmamo.roomjetpackcompose.data.dao.BookDao;
import ro.alexmamo.roomjetpackcompose.data.network.BookDb;

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
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class AppModule_ProvideBookDaoFactory implements Factory<BookDao> {
  private final AppModule module;

  private final Provider<BookDb> bookDbProvider;

  public AppModule_ProvideBookDaoFactory(AppModule module, Provider<BookDb> bookDbProvider) {
    this.module = module;
    this.bookDbProvider = bookDbProvider;
  }

  @Override
  public BookDao get() {
    return provideBookDao(module, bookDbProvider.get());
  }

  public static AppModule_ProvideBookDaoFactory create(AppModule module,
      javax.inject.Provider<BookDb> bookDbProvider) {
    return new AppModule_ProvideBookDaoFactory(module, Providers.asDaggerProvider(bookDbProvider));
  }

  public static AppModule_ProvideBookDaoFactory create(AppModule module,
      Provider<BookDb> bookDbProvider) {
    return new AppModule_ProvideBookDaoFactory(module, bookDbProvider);
  }

  public static BookDao provideBookDao(AppModule instance, BookDb bookDb) {
    return Preconditions.checkNotNullFromProvides(instance.provideBookDao(bookDb));
  }
}
