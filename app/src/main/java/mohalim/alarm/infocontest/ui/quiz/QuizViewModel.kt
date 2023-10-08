package mohalim.alarm.infocontest.ui.quiz

import android.content.Context
import android.widget.Toast
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
import mohalim.alarm.infocontest.databinding.ActivityQuizBinding
import mohalim.contest.alarm.core.repository.DatabaseRepositoryImp
import mohalim.contest.alarm.core.repository.QuestionRepositoryImp
import javax.inject.Inject
import kotlin.collections.ArrayList

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "APP")


@HiltViewModel
class QuizViewModel @Inject constructor(
    val repositoryImp: QuestionRepositoryImp,
    val databaseRepositoryImp: DatabaseRepositoryImp,
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper

) : ViewModel(){

    val LAST_RETRIEVE_TIME = longPreferencesKey("LAST_RETRIEVE_TIME")
    var lastTimeRetrieved : Long = 0


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



    fun retrieveQuestionForQuiz(type: Int, binding: ActivityQuizBinding, quizActivity: QuizActivity) {
        viewModelScope.launch {
            repositoryImp.getQuestionsForQuiz(type).collect {
                if (it.isEmpty())return@collect
                if (it.size < 25) {
                    Toast.makeText(quizActivity, "رجاء المحاولة بعد قليل يتم الان تحميل البيانات", Toast.LENGTH_LONG).show()
                }
                currentQuestion = it[0]
                questions.addAll(it)

                binding.invalidateAll()

            }
        }
    }

}