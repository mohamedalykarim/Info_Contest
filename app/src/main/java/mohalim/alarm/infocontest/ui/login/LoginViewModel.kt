package mohalim.alarm.infocontest.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mohalim.contest.alarm.core.repository.DatabaseRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val databaseRepository: DatabaseRepository) : ViewModel() {



    fun login(username: String, password: String) {
        viewModelScope.launch {
        }
    }



}