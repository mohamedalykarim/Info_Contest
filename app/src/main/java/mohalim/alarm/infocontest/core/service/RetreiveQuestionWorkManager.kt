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
import mohalim.alarm.infocontest.core.model.question.QuestionCache
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import java.io.BufferedReader
import java.io.InputStreamReader

@HiltWorker
class RetreiveQuestionWorkManager @AssistedInject constructor(
    @Assisted val appContext : Context,
    @Assisted val workerParameters: WorkerParameters,
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper
)
    : CoroutineWorker(appContext, workerParameters)  {

    companion object {
        const val ProgressMessage = "Progress_Message"
    }


    override suspend fun doWork(): Result {
        retrieve(applicationContext)

        return Result.success()

    }

    private suspend fun retrieve(context: Context) : Boolean {
        return try {

            withContext(Dispatchers.IO){
                val capitals = readFile(context, "capitals.csv")
//                val history = readFile(context, "history.csv")
//                val geography = readFile(context, "geography.csv")
//                val literature = readFile(context, "literature.csv")
//                val sports = readFile(context, "sports.csv")
//                val science = readFile(context, "science.csv")

                val update = workDataOf(ProgressMessage to "تم التحميل")
                setProgress(update)
            }


            true
        }catch (e : Exception){
            Log.d("TAG", "retrieve: error : "+ e)
            false
        }
    }

    private suspend fun readFile(context: Context, fileName: String) {
        val `is` = InputStreamReader(context.assets.open(fileName))
        val reader = BufferedReader(`is`)

        val linesCount = getLinesCount(fileName, context)

        var i =0
        val iterator = reader.lineSequence().iterator()
        while (iterator.hasNext()){
            val text = "تم تحميل "+ (i+1) +" من " + linesCount

            val update = workDataOf(ProgressMessage to text)
            setProgress(update)

            val line = iterator.next().split(",")

            val question = QuestionCache(
                line[0].replace("\uFEFF","").toInt(),
                line[1].replace("\uFEFF","").toInt(),
                line[2],
                line[3],
                line[4],
                line[5],
                line[6],
                line[7],
                line[8],
            )

            questionDao.insert(question)

            i++
        }

        reader.close()
    }

    private fun getLinesCount(fileName : String, context: Context): Int {
        val `is` = InputStreamReader(context.assets.open(fileName))
        val reader = BufferedReader(`is`)

        var lines = 0
        while (reader.readLine() != null) lines++
        reader.close()

        return lines
    }


}