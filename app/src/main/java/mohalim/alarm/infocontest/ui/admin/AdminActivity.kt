package mohalim.alarm.infocontest.ui.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.ui.login.LoginViewModel

@AndroidEntryPoint
class AdminActivity : AppCompatActivity() {
    val viewModel : AdminViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdminActivityUI(viewModel)
        }
    }
}

@Composable
fun AdminActivityUI(viewModel: AdminViewModel) {
    Column (modifier = Modifier
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





        }

    }
}