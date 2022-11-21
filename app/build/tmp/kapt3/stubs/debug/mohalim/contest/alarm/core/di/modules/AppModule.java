package mohalim.contest.alarm.core.di.modules;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lmohalim/contest/alarm/core/di/modules/AppModule;", "", "()V", "provideAWSDatabase", "Lmohalim/alarm/infocontest/core/data_source/aws/AWSDatabase;", "provideQuestionCacheMapper", "Lmohalim/alarm/infocontest/core/model/question/QuestionCacheMapper;", "app_debug"})
@dagger.Module()
public final class AppModule {
    
    public AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper provideQuestionCacheMapper() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final mohalim.alarm.infocontest.core.data_source.aws.AWSDatabase provideAWSDatabase() {
        return null;
    }
}