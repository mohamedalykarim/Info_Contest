package mohalim.alarm.infocontest.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amplifyframework.auth.result.AuthSignInResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mohalim.alarm.infocontest.core.model.user.User
import mohalim.alarm.infocontest.core.utils.DataState
import mohalim.contest.alarm.core.repository.DatabaseRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val databaseRepository: DatabaseRepository) : ViewModel() {

    private val _userDataState : MutableLiveData<DataState<AuthSignInResult>> = MutableLiveData()
    val userDataState : LiveData<DataState<AuthSignInResult>> get() = _userDataState


    fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = databaseRepository.login(username,password)
            _userDataState.value = result
        }
    }



}