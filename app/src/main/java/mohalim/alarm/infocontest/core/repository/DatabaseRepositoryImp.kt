package mohalim.contest.alarm.core.repository

import android.util.Log
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.auth.result.step.AuthSignInStep
import com.amplifyframework.core.Amplify
import mohalim.alarm.infocontest.core.data_source.aws.AWSDatabase
import javax.inject.Inject

import com.amplifyframework.datastore.generated.model.Questions
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.*
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.user.User
import mohalim.alarm.infocontest.core.utils.DataState
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class DatabaseRepositoryImp @Inject constructor(
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

    override suspend fun createQestion(question: Question): Flow<DataState<Boolean>> {
        return flow<DataState<Boolean>> {
            try {

                val item: Questions = Questions.builder()
                    .type(1)
                    .questionText("Lorem ipsum dolor sit amet")
                    .answer1("Lorem ipsum dolor sit amet")
                    .answer2("Lorem ipsum dolor sit amet")
                    .answer3("Lorem ipsum dolor sit amet")
                    .answer4("Lorem ipsum dolor sit amet")
                    .correctAnswer("Lorem ipsum dolor sit amet")
                    .comment("Lorem ipsum dolor sit amet")
                    .build()
                Amplify.DataStore.save(
                    item,
                    { success -> Log.i("Amplify", "Saved item: " + success.item().questionText) },
                    { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
                )



            }catch (e : Exception){

            }
        }.flowOn(Dispatchers.IO)
    }


}