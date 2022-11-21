// Generated by Dagger (https://dagger.dev).
package mohalim.alarm.infocontest.ui.login;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;
import mohalim.contest.alarm.core.repository.DatabaseRepository;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<DatabaseRepository> databaseRepositoryProvider;

  public LoginViewModel_Factory(Provider<DatabaseRepository> databaseRepositoryProvider) {
    this.databaseRepositoryProvider = databaseRepositoryProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(databaseRepositoryProvider.get());
  }

  public static LoginViewModel_Factory create(
      Provider<DatabaseRepository> databaseRepositoryProvider) {
    return new LoginViewModel_Factory(databaseRepositoryProvider);
  }

  public static LoginViewModel newInstance(DatabaseRepository databaseRepository) {
    return new LoginViewModel(databaseRepository);
  }
}
