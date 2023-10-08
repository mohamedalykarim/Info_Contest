package mohalim.alarm.infocontest.ui.admin

import android.app.Activity
import android.content.Intent
import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.ui.add_question.AddQuestionActivity

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

            onClick = {
                val intent = Intent(context, AddQuestionActivity::class.java)
                context.startActivity(intent)
            }
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }

    }
}