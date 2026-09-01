package ro.alexmamo.roomjetpackcompose.presentation.book_list;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
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
public final class BookListViewModel_Factory implements Factory<BookListViewModel> {
  private final Provider<BookRepository> repoProvider;

  public BookListViewModel_Factory(Provider<BookRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public BookListViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static BookListViewModel_Factory create(
      javax.inject.Provider<BookRepository> repoProvider) {
    return new BookListViewModel_Factory(Providers.asDaggerProvider(repoProvider));
  }

  public static BookListViewModel_Factory create(Provider<BookRepository> repoProvider) {
    return new BookListViewModel_Factory(repoProvider);
  }

  public static BookListViewModel newInstance(BookRepository repo) {
    return new BookListViewModel(repo);
  }
}
