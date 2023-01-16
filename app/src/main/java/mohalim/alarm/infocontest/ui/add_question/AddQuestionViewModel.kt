package mohalim.alarm.infocontest.ui.add_question

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mohalim.contest.alarm.core.repository.DatabaseRepository
import javax.inject.Inject

@HiltViewModel
class AddQuestionViewModel @Inject constructor(val databaseRepository: DatabaseRepository) : ViewModel(){
}