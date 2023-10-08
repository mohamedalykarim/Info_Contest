package mohalim.contest.alarm.core.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideQuestionCacheMapper() : QuestionCacheMapper {
        return QuestionCacheMapper()
    }

}