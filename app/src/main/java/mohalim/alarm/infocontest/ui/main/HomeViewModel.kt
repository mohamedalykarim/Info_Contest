package mohalim.alarm.infocontest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper

) : ViewModel() {

    private val _loadingProgress : MutableLiveData<Int> = MutableLiveData()
    val loadingProgress : LiveData<Int> get() = _loadingProgress



}