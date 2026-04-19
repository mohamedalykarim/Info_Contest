package mohalim.alarm.infocontest.core.data_source.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mohalim.alarm.infocontest.core.model.question.QuestionCache

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(questionCache: QuestionCache) : Long

    @Query("SELECT * FROM questions")
    suspend fun getAll() : List<QuestionCache>


    @Query("SELECT COUNT(*) FROM questions")
    suspend fun getCountAll() : Int



    @Query("SELECT * FROM questions WHERE type = :type ORDER BY RANDOM() LIMIT :limit")
    suspend fun getQuestionsFromCategory(type: Int, limit: Int): List<QuestionCache>

    @Query("SELECT DISTINCT type FROM questions")
    suspend fun getAllCategories(): List<Int>
}
