package mohalim.alarm.infocontest.ui.splash

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import mohalim.alarm.infocontest.core.service.RetreiveQuestionWorkManager
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _loadingProgress : MutableLiveData<String> = MutableLiveData()
    val loadingProgress : LiveData<String> get() = _loadingProgress


    var loadingText = "";


    fun retrieveDataToSqliteDatabase(context: Context) {
        val request : WorkRequest = OneTimeWorkRequestBuilder<RetreiveQuestionWorkManager>().build()

        val workManager = WorkManager.getInstance(context)
        workManager.enqueue(request)

        workManager.getWorkInfoByIdLiveData(request.id)
            .observe(context as LifecycleOwner) {
                loadingText = it.progress.getString("Progress_Message").toString()
                _loadingProgress.value = loadingText
            }
    }


}