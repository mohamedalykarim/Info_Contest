package mohalim.contest.alarm.core.repository

import android.util.Log
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.auth.result.step.AuthSignInStep
import com.amplifyframework.core.Amplify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mohalim.alarm.infocontest.core.data_source.aws.AWSDatabase
import javax.inject.Inject

import com.amplifyframework.datastore.generated.model.Questions
import mohalim.alarm.infocontest.core.model.question.Question
import mohalim.alarm.infocontest.core.model.user.User
import mohalim.alarm.infocontest.core.utils.DataState


class DatabaseRepositoryImp @Inject constructor(
    val data : AWSDatabase
) : DatabaseRepository {

    override fun login(username: String, password: String): Flow<DataState<AuthSignInResult>> {
        return flow {

            try {
                Amplify.Auth.signIn("mohamed.aly.karim", "Lh@123456",
                    { result ->
                        flow{
                            emit(DataState.Success(result))
                        }
                    },
                    { Log.e("AuthQuickstart", "Failed to sign in", it) }
                )

            }catch (e : Exception){
                emit(DataState.Failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun createQestion(question: Question): Flow<DataState<Boolean>> {
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