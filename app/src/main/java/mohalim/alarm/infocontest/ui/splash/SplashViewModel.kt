package mohalim.alarm.infocontest.ui.splash

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val questionDao: QuestionDao
) : ViewModel() {

    private val _isFinished = MutableLiveData<Boolean>(false)
    val isFinished: LiveData<Boolean> get() = _isFinished

    fun startLoading() {
        viewModelScope.launch {
            try {
                // Trigger database access to ensure Room copies the database from assets
               val count =  questionDao.getCountAll()
                Log.d("TAG", "startLoading: $count")



            } catch (e: Exception) {
                e.printStackTrace()
            }
            
            // Artificial delay for splash screen visibility
            delay(4000)
            _isFinished.value = true
        }
    }
}
