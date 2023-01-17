package mohalim.alarm.infocontest.core.service

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.question.QuestionCache
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.alarm.infocontest.core.utils.DataState
import mohalim.contest.alarm.core.repository.DatabaseRepositoryImp
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.log

@HiltWorker
class RetreiveQuestionWorkManager @AssistedInject constructor(
    @Assisted val appContext : Context,
    @Assisted val workerParameters: WorkerParameters,
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper,
    val databaseRepositoryImp: DatabaseRepositoryImp
)
    : CoroutineWorker(appContext, workerParameters)  {


    companion object {
        const val Progress = "Progress"
        private const val delayDuration = 1L
    }


    override suspend fun doWork(): Result {
        withContext(Dispatchers.Main){
            val currentDate = 0.0
            val result : DataState<List<Question>> = databaseRepositoryImp.getNewQuestions(currentDate)


            when (result){
                is DataState.Loading ->{}
                is DataState.Success ->{
                    result.data.forEach {
                        questionDao.insert(questionCacheMapper.mapToEntity(it))
                    }

                    val lastUpdate = workDataOf(Progress to 100)
                    setProgress(lastUpdate)

                    return@withContext Result.success()
                }
                is DataState.Failure ->{return@withContext Result.failure()}
            }


        }
        return Result.success()
    }





}