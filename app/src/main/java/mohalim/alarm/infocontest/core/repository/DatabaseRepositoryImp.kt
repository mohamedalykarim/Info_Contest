package mohalim.contest.alarm.core.repository

import android.util.Log
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

    override fun login(username: String, password: String): Flow<DataState<User>> {
        return flow {


            try {
                Amplify.Auth.signIn("mohamed.aly.karim", "Lh@123456",
                    { result ->
                        val nextStep  = result.nextStep
                        when(nextStep.signInStep){
                            AuthSignInStep.CONFIRM_SIGN_IN_WITH_SMS_MFA_CODE -> {
                                Log.i("AuthQuickstart", "SMS code sent to ${nextStep.codeDeliveryDetails?.destination}")
                                Log.i("AuthQuickstart", "Additional Info ${nextStep.additionalInfo}")
                                // Prompt the user to enter the SMS MFA code they received
                                // Then invoke `confirmSignIn` api with the code
                            }
                            AuthSignInStep.CONFIRM_SIGN_IN_WITH_CUSTOM_CHALLENGE -> {
                                Log.i("AuthQuickstart","Custom challenge, additional info: ${nextStep.additionalInfo}")
                                // Prompt the user to enter custom challenge answer
                                // Then invoke `confirmSignIn` api with the answer
                            }
                            AuthSignInStep.CONFIRM_SIGN_IN_WITH_NEW_PASSWORD -> {
                                Log.i("AuthQuickstart", "Sign in with new password, additional info: ${nextStep.additionalInfo}")
                                // Prompt the user to enter a new password
                                // Then invoke `confirmSignIn` api with new password
                            }
                            AuthSignInStep.RESET_PASSWORD -> {
                                Log.i("AuthQuickstart", "Reset password, additional info: ${nextStep.additionalInfo}")
                                // User needs to reset their password.
                                // Invoke `resetPassword` api to start the reset password
                                // flow, and once reset password flow completes, invoke
                                // `signIn` api to trigger signIn flow again.
                            }
                            AuthSignInStep.CONFIRM_SIGN_UP -> {
                                Log.i("AuthQuickstart", "Confirm signup, additional info: ${nextStep.additionalInfo}")
                                // User was not confirmed during the signup process.
                                // Invoke `confirmSignUp` api to confirm the user if
                                // they have the confirmation code. If they do not have the
                                // confirmation code, invoke `resendSignUpCode` to send the
                                // code again.
                                // After the user is confirmed, invoke the `signIn` api again.
                            }
                            AuthSignInStep.DONE -> {
                                Log.i("AuthQuickstart", "SignIn complete")
                                // User has successfully signed in to the app
                            }
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