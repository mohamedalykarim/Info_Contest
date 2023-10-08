package mohalim.contest.alarm.core.repository

import kotlinx.coroutines.flow.Flow
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.utils.DataState

interface DatabaseRepository {
    suspend fun getDataFromGoogleSheet(googleApiKey: String, sheetId: String) : Flow<DataState<List<Question>>>
}