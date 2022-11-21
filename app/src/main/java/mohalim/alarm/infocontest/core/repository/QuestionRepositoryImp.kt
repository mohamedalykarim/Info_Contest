package mohalim.contest.alarm.core.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import javax.inject.Inject

class QuestionRepositoryImp @Inject constructor(
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper
) : QuestionRepository {

    override fun getQuestionsForQuiz(type: Int): Flow<List<Question>> {
        return flow {
            val question = questionCacheMapper.mapFromEntityList(questionDao.getQuestionsFromCategory(type, 25))
            emit(question)

        }.flowOn(Dispatchers.IO)
    }
}