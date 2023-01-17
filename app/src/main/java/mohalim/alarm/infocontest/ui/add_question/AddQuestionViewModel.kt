package mohalim.alarm.infocontest.ui.add_question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.utils.DataState
import mohalim.contest.alarm.core.repository.DatabaseRepository
import javax.inject.Inject

@HiltViewModel
class AddQuestionViewModel @Inject constructor(val databaseRepository: DatabaseRepository) : ViewModel(){

    private val _addQuestionDataState : MutableLiveData<DataState<Boolean>> = MutableLiveData()
    val addQuestionDataState : LiveData<DataState<Boolean>> = _addQuestionDataState

    fun addQuestion(question: Question) {
        viewModelScope.launch {

            val addQuestionResult = databaseRepository.addQuestion(question)
            _addQuestionDataState.value = addQuestionResult
        }

    }
}