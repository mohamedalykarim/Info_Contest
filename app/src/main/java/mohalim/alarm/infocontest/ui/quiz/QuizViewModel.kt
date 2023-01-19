package mohalim.alarm.infocontest.ui.quiz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.databinding.ActivityQuizBinding
import mohalim.contest.alarm.core.repository.QuestionRepositoryImp
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(val repositoryImp: QuestionRepositoryImp) : ViewModel(){

    var currentQuestion = Question(
        "",
        1,
        "Loading...",
        "Loading...",
        "Loading...",
        "Loading...",
        "Loading...",
        "",
        "",
        false
    )

    var currentQuestionNumber = 1
    val questions : MutableList<Question> = ArrayList()

    var correctAnswersCount = 0
    var wrongAnswersCount = 0

    var isAudioEnabled = true



    fun retrieveQuestionForQuiz(type: Int, binding: ActivityQuizBinding) {
        viewModelScope.launch {
            repositoryImp.getQuestionsForQuiz(type).collect {
                if (it.isEmpty())return@collect
                currentQuestion = it[0]
                questions.addAll(it)

                binding.invalidateAll()

            }
        }
    }
}