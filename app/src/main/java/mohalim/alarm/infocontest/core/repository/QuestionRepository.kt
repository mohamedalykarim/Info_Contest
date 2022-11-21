package mohalim.contest.alarm.core.repository

import kotlinx.coroutines.flow.Flow
import mohalim.alarm.infocontest.core.model.question.Question

interface QuestionRepository {
    fun getQuestionsForQuiz(type : Int) : Flow<List<Question>>
}