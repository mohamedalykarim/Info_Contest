package mohalim.alarm.infocontest.ui.login

import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.core.utils.DataState
import mohalim.alarm.infocontest.ui.main.HomeViewModel

@AndroidEntryPoint
class AdminActivity : AppCompatActivity() {
    val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdminActivityUI(viewModel)
        }

        observe()
    }


    private fun observe() {
        viewModel.userDataState.observe(this) {
            when(it){
                is DataState.Loading -> {

                }

                is DataState.Success ->{

                }

                is DataState.Failure -> {

                }
            }
        }
    }
}



@Composable
fun AdminActivityUI(viewModel: LoginViewModel) {
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
