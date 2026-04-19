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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.ui.other_topics.OtherTopicsActivity
import mohalim.alarm.infocontest.ui.quiz.QuizActivity
import mohalim.alarm.infocontest.ui.theme.InfoContestTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val QUIZ_TYPE: String = "quiz_type"
    val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfoContestTheme {
                MainScreen(
                    onCategoryClick = { type -> startTheQuiz(type) },
                    onOtherTopicsClick = { startOtherTopics() }
                )
            }
        }
    }

    private fun startTheQuiz(type: Int) {
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra(QUIZ_TYPE, type)
        startActivity(intent)
    }

    private fun startOtherTopics() {
        val intent = Intent(this, OtherTopicsActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun MainScreen(
    onCategoryClick: (Int) -> Unit,
    onOtherTopicsClick: () -> Unit
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
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "أهلا بك، ",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = "اختار القسم المفضل لك",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
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

                Spacer(modifier = Modifier.height(8.dp))

                // Other Topics Icon
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CategoryItem(
                        title = "موضوعات أخرى",
                        iconRes = R.drawable.title, // Using title image as icon for other topics
                        isClickable = clickedType == -1,
                        onClick = {
                            clickedType = 100
                            onOtherTopicsClick()
                        }
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }

            // Ad Banner at the bottom
            AdBanner(adUnitId = "ca-app-pub-5350581213670869/9740817357")
        }
    }
}

@Composable
fun AdBanner(adUnitId: String) {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        factory = { context ->
            AdView(context).apply {
                setAdSize(AdSize.BANNER)
                this.adUnitId = adUnitId
                loadAd(AdRequest.Builder().build())
            }
        }
    )
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
            .padding(vertical = 4.dp)
            .clickable(enabled = isClickable) { onClick() },
        contentAlignment = Alignment.TopCenter
    ) {
        // The rounded background shape (#62449a, 25dp corners) - slightly smaller
        Box(
            modifier = Modifier
                .padding(top = 25.dp)
                .size(width = 150.dp, height = 120.dp)
                .background(Color(0xFF62449A), RoundedCornerShape(25.dp))
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = title,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
