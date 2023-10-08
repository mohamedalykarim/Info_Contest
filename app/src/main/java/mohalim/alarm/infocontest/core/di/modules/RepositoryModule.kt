package mohalim.contest.alarm.core.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import mohalim.alarm.infocontest.core.data_source.retrofit.UserInterfaceRetrofit
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.contest.alarm.core.repository.DatabaseRepository
import mohalim.contest.alarm.core.repository.DatabaseRepositoryImp
import mohalim.contest.alarm.core.repository.QuestionRepositoryImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideQuestionRepository(
        questionDao : QuestionDao,
        questionCacheMapper : QuestionCacheMapper
    ): QuestionRepositoryImp {
        return QuestionRepositoryImp(questionDao, questionCacheMapper)
    }

    @Singleton
    @Provides
    fun provideDatabaseRepository(
        questionDao: QuestionDao,
        questionCacheMapper: QuestionCacheMapper,
        userInterfaceRetrofit: UserInterfaceRetrofit
    ) : DatabaseRepository {
        return DatabaseRepositoryImp(questionDao, questionCacheMapper, userInterfaceRetrofit)
    }

}