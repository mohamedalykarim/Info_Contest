package mohalim.alarm.infocontest.ui.quiz

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.contest.alarm.core.repository.QuestionRepositoryImp
import javax.inject.Inject


@HiltViewModel
class QuizViewModel @Inject constructor(
    val repositoryImp: QuestionRepositoryImp,
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper
) : ViewModel() {


    var currentQuestion by mutableStateOf(
        Question(0, 1, "Loading...", "Loading...", "Loading...", "Loading...", "Loading...", "Loading...", "", "", false)
    )

    var currentQuestionNumber by mutableIntStateOf(1)
    val questions = mutableStateListOf<Question>()

    var correctAnswersCount by mutableIntStateOf(0)
    var wrongAnswersCount by mutableIntStateOf(0)

    var isAudioEnabled by mutableStateOf(true)

    var shuffledAnswers by mutableStateOf<List<String>>(emptyList())

    var selectedAnswer by mutableStateOf<String?>(null)
    var showCorrectAnswer by mutableStateOf(false)

    fun retrieveQuestionForQuiz(type: Int, context: Context) {
        viewModelScope.launch {
            repositoryImp.getQuestionsForQuiz(type).collect {
                if (it.isEmpty()) return@collect
                if (it.size < 25) {
                    Toast.makeText(context, "رجاء المحاولة بعد قليل يتم الان تحميل البيانات", Toast.LENGTH_LONG).show()
                }
                questions.clear()
                questions.addAll(it)
                updateCurrentQuestion(0)
            }
        }
    }

    private fun updateCurrentQuestion(index: Int) {
        val question = questions[index]
        currentQuestion = question
        shuffledAnswers = listOf(
            question.answer1,
            question.answer2,
            question.answer3,
            question.answer4,
            question.answer5
        ).filter { it.isNotBlank() && it != "Loading..." }.shuffled()
    }

    fun nextQuestion() {
        if (currentQuestionNumber < questions.size) {
            updateCurrentQuestion(currentQuestionNumber)
            currentQuestionNumber++
            selectedAnswer = null
            showCorrectAnswer = false
        }
    }
}
