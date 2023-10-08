package mohalim.alarm.infocontest.ui.main

import androidx.datastore.preferences.core.longPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.contest.alarm.core.repository.DatabaseRepositoryImp
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





}