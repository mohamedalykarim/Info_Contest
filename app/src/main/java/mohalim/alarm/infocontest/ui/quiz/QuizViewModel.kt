package mohalim.alarm.infocontest.ui.quiz

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.alarm.infocontest.core.utils.DataState
import mohalim.alarm.infocontest.databinding.ActivityQuizBinding
import mohalim.alarm.infocontest.ui.splash.dataStore
import mohalim.contest.alarm.core.repository.DatabaseRepositoryImp
import mohalim.contest.alarm.core.repository.QuestionRepositoryImp
import java.util.*
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
                    retrieveQuestionFromDatabase(quizActivity)
                }
                currentQuestion = it[0]
                questions.addAll(it)

                binding.invalidateAll()

            }
        }
    }

    fun retrieveQuestionFromDatabase(quizActivity: QuizActivity) {
        quizActivity.dataStore.data.map {
            lastTimeRetrieved = it[LAST_RETRIEVE_TIME] ?: 0
        }


        viewModelScope.launch(Dispatchers.IO) {
            val result : DataState<List<Question>> = databaseRepositoryImp.getNewQuestions(lastRetrieveTime = lastTimeRetrieved)
            Log.d("TAG", "retrieveDataToSqliteDatabase: "+result)

            when (result){
                is DataState.Loading ->{}
                is DataState.Success ->{
                    result.data.forEach {
                        questionDao.insert(questionCacheMapper.mapToEntity(it))
                    }

                    // update last retrieve time
                    quizActivity.dataStore.edit {
                        it[LAST_RETRIEVE_TIME] = Calendar.getInstance().time.time
                    }

                    // done
                    quizActivity.finish()

                }
                is DataState.Failure ->{
                    Log.d("TAG", "doWork: ")
                }
            }
        }
    }
}