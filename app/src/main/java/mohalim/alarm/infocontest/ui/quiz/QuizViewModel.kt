package mohalim.alarm.infocontest.ui.quiz

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.contest.alarm.core.repository.QuestionRepositoryImp
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "APP")

@HiltViewModel
class QuizViewModel @Inject constructor(
    val repositoryImp: QuestionRepositoryImp,
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper
) : ViewModel() {

    val LAST_RETRIEVE_TIME = longPreferencesKey("LAST_RETRIEVE_TIME")
    var lastTimeRetrieved: Long = 0

    var currentQuestion by mutableStateOf(
        Question(0, 1, "Loading...", "Loading...", "Loading...", "Loading...", "Loading...", "Loading...", "", "", false)
    )

    var currentQuestionNumber by mutableIntStateOf(1)
    val questions = mutableStateListOf<Question>()

    var correctAnswersCount by mutableIntStateOf(0)
    var wrongAnswersCount by mutableIntStateOf(0)

    var isAudioEnabled by mutableStateOf(true)

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
                currentQuestion = questions[0]
            }
        }
    }

    fun nextQuestion() {
        if (currentQuestionNumber < questions.size) {
            currentQuestion = questions[currentQuestionNumber]
            currentQuestionNumber++
            selectedAnswer = null
            showCorrectAnswer = false
        }
    }
}
