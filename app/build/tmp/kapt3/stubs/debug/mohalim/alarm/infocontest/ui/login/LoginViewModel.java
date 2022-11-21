package mohalim.alarm.infocontest.ui.login;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lmohalim/alarm/infocontest/ui/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "databaseRepository", "Lmohalim/contest/alarm/core/repository/DatabaseRepository;", "(Lmohalim/contest/alarm/core/repository/DatabaseRepository;)V", "_userDataState", "Landroidx/lifecycle/MutableLiveData;", "Lmohalim/alarm/infocontest/core/utils/DataState;", "Lmohalim/alarm/infocontest/core/model/user/User;", "getDatabaseRepository", "()Lmohalim/contest/alarm/core/repository/DatabaseRepository;", "userDataState", "Landroidx/lifecycle/LiveData;", "getUserDataState", "()Landroidx/lifecycle/LiveData;", "login", "", "username", "", "password", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final mohalim.contest.alarm.core.repository.DatabaseRepository databaseRepository = null;
    private final androidx.lifecycle.MutableLiveData<mohalim.alarm.infocontest.core.utils.DataState<mohalim.alarm.infocontest.core.model.user.User>> _userDataState = null;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    mohalim.contest.alarm.core.repository.DatabaseRepository databaseRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final mohalim.contest.alarm.core.repository.DatabaseRepository getDatabaseRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<mohalim.alarm.infocontest.core.utils.DataState<mohalim.alarm.infocontest.core.model.user.User>> getUserDataState() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
}