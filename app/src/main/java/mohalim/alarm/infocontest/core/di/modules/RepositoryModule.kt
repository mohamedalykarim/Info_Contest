package mohalim.contest.alarm.core.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext

import dagger.hilt.components.SingletonComponent
import mohalim.alarm.infocontest.core.data_source.retrofit.UserInterfaceRetrofit
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.alarm.infocontest.core.utils.PreferencesManager
import mohalim.contest.alarm.core.repository.QuestionRepositoryImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideQuestionRepository(
        questionDao : QuestionDao,
        questionCacheMapper : QuestionCacheMapper,
        @ApplicationContext context: Context
    ): QuestionRepositoryImp {
        return QuestionRepositoryImp(
            questionDao, questionCacheMapper,
            preferencesManager = PreferencesManager(context)

        )
    }

}