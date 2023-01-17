package mohalim.alarm.infocontest.ui.splash

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import mohalim.alarm.infocontest.core.service.RetreiveQuestionWorkManager
import mohalim.alarm.infocontest.core.service.RetreiveQuestionWorkManager.Companion.Progress
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _loadingProgress : MutableLiveData<Int> = MutableLiveData()
    val loadingProgress : LiveData<Int> get() = _loadingProgress




    fun retrieveDataToSqliteDatabase(context: Context) {
        val request : WorkRequest = OneTimeWorkRequestBuilder<RetreiveQuestionWorkManager>().build()

        val workManager = WorkManager.getInstance(context)
        workManager.enqueue(request)

        workManager.getWorkInfoByIdLiveData(request.id)
            .observe(context as LifecycleOwner) {workInfo->
                if (workInfo != null) {
                    val progress = workInfo.progress
                    val value = progress.getInt(Progress, 0)
                    _loadingProgress.value = value
                }

            }
    }


}