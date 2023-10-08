package mohalim.contest.alarm.core.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mohalim.alarm.infocontest.core.data_source.retrofit.UserInterfaceRetrofit
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.alarm.infocontest.core.utils.DataState
import org.json.JSONObject
import javax.inject.Inject


class DatabaseRepositoryImp @Inject constructor(
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper,
    val userInterfaceRetrofit: UserInterfaceRetrofit
) : DatabaseRepository {



    override suspend fun getDataFromGoogleSheet(
        googleApiKey: String,
        sheetId: String
    ): Flow<DataState<List<Question>>> {
        return flow {
            try {
                val questions = mutableListOf<Question>()

                val response = userInterfaceRetrofit.getDatabase(sheetId, googleApiKey)
                val jsonObject = JSONObject(response.body()!!.string())
                val array = jsonObject.getJSONArray("values")

                for (i in 0 until array.length()){
                    if (i > 0){
                        val item = array.getJSONArray(i)
                        questions.add(
                            Question(
                                item.get(0).toString(),
                                item.get(1).toString().toInt(),
                                item.get(2).toString(),
                                item.get(3).toString(),
                                item.get(4).toString(),
                                item.get(5).toString(),
                                item.get(6).toString(),
                                item.get(7).toString(),
                                "",
                                false
                            )
                        )


                    }
                }
                emit(DataState.Success(questions))


            }catch (e : Exception){
                Log.d("TAG", "getDataFromGoogleSheet: "+e.message)
                emit(DataState.Failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }


}