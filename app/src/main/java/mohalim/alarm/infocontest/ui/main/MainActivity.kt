package mohalim.alarm.infocontest.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.ui.quiz.QuizActivity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val QUIZ_TYPE: String = "quiz_type"
    val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen(
                    onCategoryClick = { type -> startTheQuiz(type) },
                )
            }
        }
    }

    private fun startTheQuiz(type: Int) {
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra(QUIZ_TYPE, type)
        startActivity(intent)
    }
}

@Composable
fun MainScreen(
    onCategoryClick: (Int) -> Unit,
) {
    // Reset clicked state when returning to this screen
    var clickedType by remember { mutableIntStateOf(-1) }
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                clickedType = -1
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF564CE9), Color(0xFFB66CB6))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Welcome guest, ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Text(
                text = "Choose a category",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    CategoryItem(
                        title = "العواصم",
                        iconRes = R.drawable.capital_icon,
                        isClickable = clickedType == -1,
                        onClick = {
                            clickedType = 1
                            onCategoryClick(1)
                        }
                    )
                    CategoryItem(
                        title = "الجغرافيا",
                        iconRes = R.drawable.geography_icon,
                        isClickable = clickedType == -1,
                        onClick = {
                            clickedType = 3
                            onCategoryClick(3)
                        }
                    )
                    CategoryItem(
                        title = "الرياضة",
                        iconRes = R.drawable.sports_icon,
                        isClickable = clickedType == -1,
                        onClick = {
                            clickedType = 5
                            onCategoryClick(5)
                        }
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    CategoryItem(
                        title = "التاريخ",
                        iconRes = R.drawable.history_icon,
                        isClickable = clickedType == -1,
                        onClick = {
                            clickedType = 2
                            onCategoryClick(2)
                        }
                    )
                    CategoryItem(
                        title = "الأدب",
                        iconRes = R.drawable.literature_icon,
                        isClickable = clickedType == -1,
                        onClick = {
                            clickedType = 4
                            onCategoryClick(4)
                        }
                    )
                    CategoryItem(
                        title = "العلوم",
                        iconRes = R.drawable.science_icon,
                        isClickable = clickedType == -1,
                        onClick = {
                            clickedType = 6
                            onCategoryClick(6)
                        }
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun CategoryItem(
    title: String,
    iconRes: Int,
    isClickable: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(enabled = isClickable) { onClick() },
        contentAlignment = Alignment.TopCenter
    ) {
        // The rounded background shape (#62449a, 30dp corners)
        Box(
            modifier = Modifier
                .padding(top = 30.dp)
                .size(width = 170.dp, height = 140.dp)
                .background(Color(0xFF62449A), RoundedCornerShape(30.dp))
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}
