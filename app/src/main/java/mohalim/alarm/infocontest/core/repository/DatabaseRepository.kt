package mohalim.contest.alarm.core.repository

import com.amplifyframework.auth.result.AuthSignInResult
import kotlinx.coroutines.flow.Flow
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.utils.DataState

interface DatabaseRepository {
    fun login(username : String, password: String) : Flow<DataState<AuthSignInResult>>
    fun createQestion(question: Question) : Flow<DataState<Boolean>>
}