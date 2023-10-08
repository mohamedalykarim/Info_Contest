package mohalim.alarm.infocontest.ui.splash

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.alarm.infocontest.core.utils.DataState
import mohalim.contest.alarm.core.repository.DatabaseRepositoryImp
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





    fun getDataFromGoogleSheet(googleApiKey: String, sheetId: String) {
        viewModelScope.launch {
            databaseRepositoryImp.getDataFromGoogleSheet(googleApiKey, sheetId).collect{ it ->
                when (it){
                    is DataState.Loading ->{
                    }
                    is DataState.Success ->{
                        it.data.forEach {
                            questionDao.insert(questionCacheMapper.mapToEntity(it))
                        }

                        // done
                        withContext(Dispatchers.Main) {
                            _loadingProgress.value = it.data
                        }

                    }
                    is DataState.Failure ->{
                    }
                }
            }
        }
    }


}