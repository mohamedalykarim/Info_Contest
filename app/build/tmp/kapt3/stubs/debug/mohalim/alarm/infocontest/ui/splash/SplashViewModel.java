package mohalim.alarm.infocontest.ui.splash;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lmohalim/alarm/infocontest/ui/splash/SplashViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_loadingProgress", "Landroidx/lifecycle/MutableLiveData;", "", "loadingProgress", "Landroidx/lifecycle/LiveData;", "getLoadingProgress", "()Landroidx/lifecycle/LiveData;", "loadingText", "getLoadingText", "()Ljava/lang/String;", "setLoadingText", "(Ljava/lang/String;)V", "retrieveDataToSqliteDatabase", "", "context", "Landroid/content/Context;", "app_debug"})
public final class SplashViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _loadingProgress = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String loadingText = "";
    
    @javax.inject.Inject()
    public SplashViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getLoadingProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLoadingText() {
        return null;
    }
    
    public final void setLoadingText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final void retrieveDataToSqliteDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}