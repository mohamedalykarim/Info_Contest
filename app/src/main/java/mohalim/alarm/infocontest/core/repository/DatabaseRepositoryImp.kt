package mohalim.contest.alarm.core.repository

import android.util.Log
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Where
import mohalim.alarm.infocontest.core.data_source.aws.AWSDatabase
import javax.inject.Inject

import com.amplifyframework.datastore.generated.model.Questions
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper
import mohalim.alarm.infocontest.core.utils.DataState
import java.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class DatabaseRepositoryImp @Inject constructor(
    val questionDao: QuestionDao,
    val questionCacheMapper: QuestionCacheMapper,
    val data : AWSDatabase
) : DatabaseRepository {

    override suspend fun login(username: String, password: String): DataState<AuthSignInResult> = suspendCoroutine {continuation->

        try {
            Amplify.Auth.signIn(username, password,
                { result ->
                    continuation.resume(DataState.Success(result))
                },
                {
                    continuation.resume(DataState.Failure(it))
                    Log.e("AuthQuickstart", "Failed to sign in", it)
                }
            )

        }catch (e : Exception){
            continuation.resume(DataState.Failure(e))
        }


    }

    override suspend fun addQuestion(question: Question): DataState<Boolean> = suspendCoroutine { continuation->
        try {

            val time= Calendar.getInstance().time.time

            val item: Questions = Questions.builder()
                .type(question.type)
                .questionText(question.questionText)
                .answer1(question.answer1)
                .answer2(question.answer2)
                .answer3(question.answer3)
                .answer4(question.answer4)
                .correctAnswer(question.correctAnswer)
                .comment(question.comment)
                .timeAddedToDatabase(time.toDouble())
                .build()
            Amplify.DataStore.save(
                item,
                { success -> continuation.resume(DataState.Success(true)) },
                { error -> continuation.resume(DataState.Failure(error)) }
            )

        }catch (e : Exception){

        }

    }

    override suspend fun getNewQuestions(lastRetrieveTime : Double): DataState<List<Question>> = suspendCoroutine {
        try {
            Amplify.DataStore.query(
                Questions::class.java,
                Where.matches(Questions.TIME_ADDED_TO_DATABASE.gt(0)),
                {questionsData->
                    val questions = mutableListOf<Question>()
                    while (questionsData.hasNext()){
                        val questionData = questionsData.next()
                        questions.add(
                            Question(
                                questionData.id,
                                questionData.type,
                                questionData.questionText,
                                questionData.answer1,
                                questionData.answer2,
                                questionData.answer3,
                                questionData.answer4,
                                questionData.correctAnswer,
                                questionData.comment,
                                false
                            )
                        )
                    }

                    it.resume(DataState.Success(questions))
                },
                {exception->
                    Log.d("TAG", "getNewQuestions: ")
                    it.resume(DataState.Failure(exception))
                }
            )

        }catch (exception : Exception){
            Log.d("TAG", "getNewQuestions: ")
            it.resume(DataState.Failure(exception))

        }
    }


}