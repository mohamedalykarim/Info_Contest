package mohalim.contest.alarm.core.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lmohalim/contest/alarm/core/repository/DatabaseRepository;", "", "login", "Lkotlinx/coroutines/flow/Flow;", "Lmohalim/alarm/infocontest/core/utils/DataState;", "Lmohalim/alarm/infocontest/core/model/user/User;", "username", "", "password", "app_debug"})
public abstract interface DatabaseRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<mohalim.alarm.infocontest.core.utils.DataState<mohalim.alarm.infocontest.core.model.user.User>> login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password);
}