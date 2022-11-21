package mohalim.contest.alarm.core.di.modules;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lmohalim/contest/alarm/core/di/modules/RepositoryModule;", "", "()V", "provideDatabaseRepository", "Lmohalim/contest/alarm/core/repository/DatabaseRepository;", "data", "Lmohalim/alarm/infocontest/core/data_source/aws/AWSDatabase;", "provideQuestionRepository", "Lmohalim/contest/alarm/core/repository/QuestionRepositoryImp;", "questionDao", "Lmohalim/alarm/infocontest/core/data_source/room/QuestionDao;", "questionCacheMapper", "Lmohalim/alarm/infocontest/core/model/question/QuestionCacheMapper;", "app_debug"})
@dagger.Module()
public final class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final mohalim.contest.alarm.core.repository.QuestionRepositoryImp provideQuestionRepository(@org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.core.data_source.room.QuestionDao questionDao, @org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper questionCacheMapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final mohalim.contest.alarm.core.repository.DatabaseRepository provideDatabaseRepository(@org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.core.data_source.aws.AWSDatabase data) {
        return null;
    }
}