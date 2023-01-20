package mohalim.alarm.infocontest.ui.main

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.alarm.infocontest.core.utils.DataState
import mohalim.alarm.infocontest.ui.splash.dataStore
import mohalim.contest.alarm.core.repository.DatabaseRepositoryImp
import mohalim.contest.alarm.core.repository.QuestionRepositoryImp
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val databaseRepositoryImp : DatabaseRepositoryImp,
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper

) : ViewModel() {


    val LAST_RETRIEVE_TIME = longPreferencesKey("LAST_RETRIEVE_TIME")
    var lastTimeRetrieved : Long = 0

    private val _loadingProgress : MutableLiveData<Int> = MutableLiveData()
    val loadingProgress : LiveData<Int> get() = _loadingProgress




    fun retrieveDataToSqliteDatabase(context: Context) {
        context.dataStore.data.map {
            lastTimeRetrieved = it[LAST_RETRIEVE_TIME] ?: 0
        }


        viewModelScope.launch(Dispatchers.IO) {
            delay(5000)
            val result : DataState<List<Question>> = databaseRepositoryImp.getNewQuestions(lastRetrieveTime = lastTimeRetrieved)
            Log.d("TAG", "retrieveDataToSqliteDatabase: "+result)

            when (result){
                is DataState.Loading ->{}
                is DataState.Success ->{
                    result.data.forEach {
                        questionDao.insert(questionCacheMapper.mapToEntity(it))
                    }

                    // update last retrieve time
                    context.dataStore.edit {
                        it[LAST_RETRIEVE_TIME] = Calendar.getInstance().time.time
                    }

                    // done
                    withContext(Dispatchers.Main) {
//                        _loadingProgress.value = 100
                    }

                }
                is DataState.Failure ->{
                    Log.d("TAG", "doWork: ")
                }
            }
        }

    }


}