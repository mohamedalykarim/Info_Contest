package mohalim.contest.alarm.core.repository

import kotlinx.coroutines.flow.Flow
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.user.User
import mohalim.alarm.infocontest.core.utils.DataState

interface DatabaseRepository {
    fun login(username : String, password: String) : Flow<DataState<User>>
}