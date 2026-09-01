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
import ro.alexmamo.roomjetpackcompose.domain.repository.BookRepository;

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
public final class AppModule_ProvideBookRepositoryFactory implements Factory<BookRepository> {
  private final AppModule module;

  private final Provider<BookDao> bookDaoProvider;

  public AppModule_ProvideBookRepositoryFactory(AppModule module,
      Provider<BookDao> bookDaoProvider) {
    this.module = module;
    this.bookDaoProvider = bookDaoProvider;
  }

  @Override
  public BookRepository get() {
    return provideBookRepository(module, bookDaoProvider.get());
  }

  public static AppModule_ProvideBookRepositoryFactory create(AppModule module,
      javax.inject.Provider<BookDao> bookDaoProvider) {
    return new AppModule_ProvideBookRepositoryFactory(module, Providers.asDaggerProvider(bookDaoProvider));
  }

  public static AppModule_ProvideBookRepositoryFactory create(AppModule module,
      Provider<BookDao> bookDaoProvider) {
    return new AppModule_ProvideBookRepositoryFactory(module, bookDaoProvider);
  }

  public static BookRepository provideBookRepository(AppModule instance, BookDao bookDao) {
    return Preconditions.checkNotNullFromProvides(instance.provideBookRepository(bookDao));
  }
}
