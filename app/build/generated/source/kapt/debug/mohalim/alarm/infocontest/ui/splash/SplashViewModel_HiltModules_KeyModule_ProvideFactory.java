// Generated by Dagger (https://dagger.dev).
package mohalim.alarm.infocontest.ui.splash;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SplashViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static SplashViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(SplashViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final SplashViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SplashViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
