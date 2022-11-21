package mohalim.alarm.infocontest.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mohalim.alarm.infocontest.core.model.user.User
import mohalim.alarm.infocontest.core.utils.DataState
import mohalim.contest.alarm.core.repository.DatabaseRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val databaseRepository: DatabaseRepository) : ViewModel() {

    private val _userDataState : MutableLiveData<DataState<User>> = MutableLiveData()
    val userDataState : LiveData<DataState<User>> get() = _userDataState


    fun login(username: String, password: String) {
        viewModelScope.launch {
            databaseRepository.login(username,password).collect{
                _userDataState.value = it
            }
        }

    }
}