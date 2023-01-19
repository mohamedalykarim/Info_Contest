package mohalim.contest.alarm.core.repository

import com.amplifyframework.auth.result.AuthSignInResult
import kotlinx.coroutines.flow.Flow
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.utils.DataState

interface DatabaseRepository {
    suspend fun login(username : String, password: String) : DataState<AuthSignInResult>
    suspend fun addQuestion(question: Question): DataState<Boolean>
    suspend fun getNewQuestions(lastRetrieveTime : Long) : DataState<List<Question>>
}