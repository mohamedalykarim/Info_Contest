package mohalim.contest.alarm.core.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lmohalim/contest/alarm/core/repository/DatabaseRepositoryImp;", "Lmohalim/contest/alarm/core/repository/DatabaseRepository;", "data", "Lmohalim/alarm/infocontest/core/data_source/aws/AWSDatabase;", "(Lmohalim/alarm/infocontest/core/data_source/aws/AWSDatabase;)V", "getData", "()Lmohalim/alarm/infocontest/core/data_source/aws/AWSDatabase;", "login", "Lkotlinx/coroutines/flow/Flow;", "Lmohalim/alarm/infocontest/core/utils/DataState;", "Lmohalim/alarm/infocontest/core/model/user/User;", "username", "", "password", "app_debug"})
public final class DatabaseRepositoryImp implements mohalim.contest.alarm.core.repository.DatabaseRepository {
    @org.jetbrains.annotations.NotNull()
    private final mohalim.alarm.infocontest.core.data_source.aws.AWSDatabase data = null;
    
    @javax.inject.Inject()
    public DatabaseRepositoryImp(@org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.core.data_source.aws.AWSDatabase data) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final mohalim.alarm.infocontest.core.data_source.aws.AWSDatabase getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<mohalim.alarm.infocontest.core.utils.DataState<mohalim.alarm.infocontest.core.model.user.User>> login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
}