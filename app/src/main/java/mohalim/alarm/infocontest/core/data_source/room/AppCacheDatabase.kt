package mohalim.alarm.infocontest.core.data_source.room

import androidx.room.Database
import androidx.room.RoomDatabase
import mohalim.alarm.infocontest.core.model.question.QuestionCache

@Database(entities = [QuestionCache::class], version = 3, exportSchema = false)
abstract class AppCacheDatabase : RoomDatabase() {
    abstract fun questionDao() : QuestionDao

    companion object{
        const val DATABASE_NAME = "mohalim_info_contest"
    }
}