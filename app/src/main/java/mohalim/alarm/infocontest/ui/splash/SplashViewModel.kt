package mohalim.alarm.infocontest.ui.splash

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.*
import androidx.work.*
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
import mohalim.contest.alarm.core.repository.DatabaseRepositoryImp
import java.util.*
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "APP")


@HiltViewModel
class SplashViewModel @Inject constructor(
    val databaseRepositoryImp: DatabaseRepositoryImp,
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper

    ) : ViewModel() {

    private val _loadingProgress : MutableLiveData<List<Question>?> = MutableLiveData()
    val loadingProgress : LiveData<List<Question>?> get() = _loadingProgress


    val LAST_RETRIEVE_TIME = longPreferencesKey("LAST_RETRIEVE_TIME")
    var lastTimeRetrieved : Long = 0



    fun retrieveDataToSqliteDatabase(context: Context) {
        context.dataStore.data.map {
            lastTimeRetrieved = it[LAST_RETRIEVE_TIME] ?: 0
        }


        viewModelScope.launch(Dispatchers.IO) {
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
                        _loadingProgress.value = result.data

                    }

                }
                is DataState.Failure ->{
                    Log.d("TAG", "doWork: ")
                }
            }
        }
        
    }

    fun getDataFromGoogleSheet(googleApiKey: String, sheetId: String) {
        viewModelScope.launch {
            databaseRepositoryImp.getDataFromGoogleSheet(googleApiKey, sheetId).collect{

            }
        }
    }


}