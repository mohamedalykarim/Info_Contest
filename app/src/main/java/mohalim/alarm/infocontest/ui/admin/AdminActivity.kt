package mohalim.alarm.infocontest.ui.admin

import android.app.Activity
import android.content.Context
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
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult
import com.amplifyframework.core.Amplify
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.ui.login.LoginViewModel
import mohalim.alarm.infocontest.ui.main.MainActivity

@AndroidEntryPoint
class AdminActivity : AppCompatActivity() {
    val viewModel : AdminViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdminActivityUI(viewModel, this@AdminActivity)
        }
    }


}

@Composable
fun AdminActivityUI(viewModel: AdminViewModel, context: Activity) {
    Box (modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.linearGradient(
                colors = listOf(
                    Color(android.graphics.Color.parseColor("#564ce9")),
                    Color(android.graphics.Color.parseColor("#b66cb6")),
                ),
                start = Offset(Float.POSITIVE_INFINITY, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            )
        ))

    {
        
       Button(
           onClick = {
               Amplify.Auth.signOut { signOutResult ->
                   when(signOutResult) {
                       is AWSCognitoAuthSignOutResult.CompleteSignOut -> {
                           // Sign Out completed fully and without errors.
                           Log.i("AuthQuickStart", "Signed out successfully")
                           context.finish()

                       }
                       is AWSCognitoAuthSignOutResult.PartialSignOut -> {
                           // Sign Out completed with some errors. User is signed out of the device.
                           signOutResult.hostedUIError?.let {
                               Log.e("AuthQuickStart", "HostedUI Error", it.exception)
                               // Optional: Re-launch it.url in a Custom tab to clear Cognito web session.

                           }
                           signOutResult.globalSignOutError?.let {
                               Log.e("AuthQuickStart", "GlobalSignOut Error", it.exception)
                               // Optional: Use escape hatch to retry revocation of it.accessToken.
                           }
                           signOutResult.revokeTokenError?.let {
                               Log.e("AuthQuickStart", "RevokeToken Error", it.exception)
                               // Optional: Use escape hatch to retry revocation of it.refreshToken.
                           }
                       }
                       is AWSCognitoAuthSignOutResult.FailedSignOut -> {
                           // Sign Out failed with an exception, leaving the user signed in.
                           Log.e("AuthQuickStart", "Sign out Failed", signOutResult.exception)
                       }
                   }
               }


           }) {
           Text(
               color = Color(parseColor("#ffffff")),
               text = "Sign out"
           )

       }

        FloatingActionButton(
            modifier = Modifier
                .padding(all = 16.dp)
                .align(alignment = Alignment.BottomEnd),

            onClick = { /*TODO*/ }
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }

    }
}