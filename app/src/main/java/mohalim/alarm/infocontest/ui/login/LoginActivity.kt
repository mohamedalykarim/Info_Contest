package mohalim.alarm.infocontest.ui.login

import android.content.Intent
import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.amplifyframework.auth.result.step.AuthSignInStep
import com.amplifyframework.core.Amplify
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.core.utils.DataState
import mohalim.alarm.infocontest.ui.admin.AdminActivity
import mohalim.alarm.infocontest.ui.main.HomeViewModel
import mohalim.alarm.infocontest.ui.quiz.QuizActivity

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginActivityUI(viewModel)
        }

        observe()
    }

    override fun onResume() {
        super.onResume()

        Amplify.Auth.fetchAuthSession(
            {
                if(it.isSignedIn){
                    val intent = Intent(this@LoginActivity, AdminActivity::class.java)
                    this.finish()
                    startActivity(intent)

                }
            },
            { error -> Log.e("AmplifyQuickstart", "Failed to fetch auth session", error) }
        )
    }


    private fun observe() {
        viewModel.userDataState.observe(this) {
            when(it){
                is DataState.Loading -> {

                }

                is DataState.Success ->{
                    val nextStep  = it.data.nextStep
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
                            val intent = Intent(this, AdminActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                is DataState.Failure -> {

                }
            }
        }
    }
}



@Composable
fun LoginActivityUI(viewModel: LoginViewModel) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.linearGradient(
                colors = listOf(
                    Color(parseColor("#564ce9")),
                    Color(parseColor("#b66cb6")),
                ),
                start = Offset(Float.POSITIVE_INFINITY, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            )
        ))

    {
        
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(id = R.drawable.admin_logo)
            
            Spacer(modifier = Modifier.width(10.dp))

            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = image, contentDescription = null)

            Spacer(modifier = Modifier.width(10.dp))

            var username by remember { mutableStateOf(TextFieldValue("")) }
            var password by remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(parseColor("#ffffff")),
                    focusedIndicatorColor = Color(parseColor("#da9f09")),
                    focusedLabelColor = Color(parseColor("#313131")),
                ),
                label = { Text("Username") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    ),
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = null)
                }
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(parseColor("#ffffff")),
                    focusedIndicatorColor = Color(parseColor("#da9f09")),
                    focusedLabelColor = Color(parseColor("#313131")),
                ),
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    ),
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Password, contentDescription = null)
                }
            )

            Button(onClick = {
                viewModel.login(username.text, password.text)
            }) {
                Text(text = "Login")
            }

        }

    }
}
