package mohalim.contest.alarm.core.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mohalim.alarm.infocontest.core.data_source.room.AppCacheDatabase
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CahcheDatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) : AppCacheDatabase {
        return Room.databaseBuilder(
            context,
            AppCacheDatabase::class.java,
            AppCacheDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideQuestionDao(appCacheDatabase: AppCacheDatabase) : QuestionDao {
        return appCacheDatabase.questionDao()
    }
}