package mohalim.alarm.infocontest.core.model.question


import mohalim.alarm.infocontest.core.utils.EntityMapper
import javax.inject.Inject

class QuestionCacheMapper @Inject constructor(): EntityMapper<QuestionCache, Question> {
    override fun mapFromEntity(entity: QuestionCache): Question {
        return Question(
            id = entity.id,
            type = entity.type,
            questionText = entity.questionText,
            answer1 = entity.answer1,
            answer2 = entity.answer2,
            answer3 = entity.answer3,
            answer4 = entity.answer4,
            answer5 = entity.answer5,
            correctAnswer = entity.correctAnswer,
            extraInfo =  entity.extraInfo,
            isAnswered = false
        )

    }

    override fun mapToEntity(domainModel: Question): QuestionCache {
        return QuestionCache(
            id = domainModel.id,
            type = domainModel.type,
            questionText = domainModel.questionText,
            answer1 = domainModel.answer1,
            answer2 = domainModel.answer2,
            answer3 = domainModel.answer3,
            answer4 = domainModel.answer4,
            answer5 = domainModel.answer5,
            correctAnswer = domainModel.correctAnswer,
            extraInfo =  domainModel.extraInfo,
        )
    }

    fun mapFromEntityList(entities : List<QuestionCache>) : List<Question>{
        return entities.map { mapFromEntity(it) }
    }


}
