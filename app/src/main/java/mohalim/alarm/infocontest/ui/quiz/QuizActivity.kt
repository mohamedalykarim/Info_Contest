package mohalim.alarm.infocontest.ui.quiz

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.ui.result.ResultActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mohalim.alarm.infocontest.ui.theme.InfoContestTheme

@AndroidEntryPoint
class QuizActivity : ComponentActivity() {
    private val QUIZ_TYPE: String = "quiz_type"
    val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = intent.getIntExtra(QUIZ_TYPE, 1)
        viewModel.retrieveQuestionForQuiz(type, this)

        setContent {
            InfoContestTheme {
                QuizScreen(viewModel, type) { correct, wrong ->
                    val intent = Intent(this@QuizActivity, ResultActivity::class.java).apply {
                        putExtra("CORRECT", correct)
                        putExtra("WRONG", wrong)
                    }
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}

@Composable
fun QuizScreen(viewModel: QuizViewModel, type: Int, onFinish: (Int, Int) -> Unit) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var showExtraInfoDialog by remember { mutableStateOf(false) }

    val title = remember(type) {
        when (type) {
            1 -> "العواصم"
            2 -> "التاريخ"
            3 -> "الجغرافيا"
            4 -> "الأدب"
            5 -> "الرياضة"
            6 -> "العلوم"
            else -> "مسابقة"
        }
    }

    fun playSound(resId: Int) {
        if (viewModel.isAudioEnabled) {
            try {
                val mediaPlayer = MediaPlayer.create(context, resId)
                mediaPlayer.start()
                mediaPlayer.setOnCompletionListener {
                    it.release()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
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
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { 
                        Text(
                            text = title, 
                            modifier = Modifier.fillMaxWidth(), 
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        ) 
                    },
                    backgroundColor = Color.Transparent,
                    contentColor = Color.White,
                    elevation = 0.dp,
                    actions = {
                        IconButton(onClick = { viewModel.isAudioEnabled = !viewModel.isAudioEnabled }) {
                            Icon(
                                imageVector = if (viewModel.isAudioEnabled) Icons.AutoMirrored.Filled.VolumeUp else Icons.AutoMirrored.Filled.VolumeOff,
                                contentDescription = "Audio"
                            )
                        }
                    }
                )
            },
            backgroundColor = Color.Transparent
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 20.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    // Progress Section
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color.White.copy(alpha = 0.2f),
                    ) {
                        Text(
                            text = "السؤال ${viewModel.currentQuestionNumber} / 25",
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Question Section
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = 8.dp,
                        shape = RoundedCornerShape(25.dp),
                        backgroundColor = Color.White
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = viewModel.currentQuestion.questionText,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 28.sp,
                                color = Color(0xFF1A1A1A)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Choices Section (Using pre-shuffled answers from ViewModel)
                    viewModel.shuffledAnswers.forEachIndexed { index, choice ->
                        ChoiceButton(
                            text = choice,
                            index = index + 1,
                            isSelected = viewModel.selectedAnswer == choice,
                            isCorrect = viewModel.currentQuestion.correctAnswer == choice,
                            showResult = viewModel.showCorrectAnswer,
                            enabled = viewModel.selectedAnswer == null,
                            onClick = {
                                viewModel.selectedAnswer = choice
                                playSound(R.raw.button_answer)
                                
                                scope.launch {
                                    delay(300) 
                                    viewModel.showCorrectAnswer = true
                                    if (choice == viewModel.currentQuestion.correctAnswer) {
                                        viewModel.correctAnswersCount++
                                        playSound(R.raw.correct_answer)
                                    } else {
                                        viewModel.wrongAnswersCount++
                                        playSound(R.raw.wrong_answer)
                                    }
                                    
                                    delay(1200) 
                                    viewModel.currentQuestion = viewModel.currentQuestion.copy(isAnswered = true)
                                    // Show info dialog after answer is processed
                                    showExtraInfoDialog = true
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                    
                    Spacer(modifier = Modifier.height(40.dp))
                }

                // Ad Banner at the bottom
                AdBanner(adUnitId = "ca-app-pub-5350581213670869/9740817357")
            }
        }
    }

    // Extra Info Dialog
    if (showExtraInfoDialog) {
        Dialog(onDismissRequest = {
            showExtraInfoDialog = false
            if (viewModel.currentQuestionNumber == 25) {
                onFinish(viewModel.correctAnswersCount, viewModel.wrongAnswersCount)
            } else {
                viewModel.nextQuestion()
            }
        }) {
            Card(
                shape = RoundedCornerShape(24.dp),
                elevation = 16.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "معلومة إضافية",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF564CE9)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text(
                        text = viewModel.currentQuestion.extraInfo,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 26.sp,
                        color = Color.DarkGray
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Button(
                        onClick = {
                            showExtraInfoDialog = false
                            if (viewModel.currentQuestionNumber == 25) {
                                onFinish(viewModel.correctAnswersCount, viewModel.wrongAnswersCount)
                            } else {
                                viewModel.nextQuestion()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFF564CE9),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = if (viewModel.currentQuestionNumber == 25) "النتيجة" else "السؤال التالي",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
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
fun ChoiceButton(
    text: String,
    index: Int,
    isSelected: Boolean,
    isCorrect: Boolean,
    showResult: Boolean,
    enabled: Boolean,
    onClick: () -> Unit
) {
    var isFlickerOn by remember { mutableStateOf(false) }

    LaunchedEffect(showResult) {
        if (showResult && (isCorrect || isSelected)) {
            repeat(4) {
                isFlickerOn = true
                delay(80)
                isFlickerOn = false
                delay(80)
            }
            isFlickerOn = true 
        } else {
            isFlickerOn = false
        }
    }

    val backgroundColor = when {
        showResult && isFlickerOn && isCorrect -> Color(0xFF4CAF50)
        showResult && isFlickerOn && isSelected && !isCorrect -> Color(0xFFF44336)
        isSelected -> Color(0xFF9575CD).copy(alpha = 0.9f)
        else -> Color.White.copy(alpha = 0.9f)
    }

    val contentColor = when {
        showResult && isFlickerOn && (isCorrect || isSelected) -> Color.White
        isSelected -> Color.White
        else -> Color(0xFF642EA8)
    }

    val numberBgColor = when {
        showResult && isFlickerOn && (isCorrect || isSelected) -> Color.White.copy(alpha = 0.3f)
        isSelected -> Color.White.copy(alpha = 0.3f)
        else -> Color(0xFF564CE9).copy(alpha = 0.1f)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .clickable(enabled = enabled, onClick = onClick),
        elevation = if (isSelected) 8.dp else 2.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Styled Numbering
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(numberBgColor, CircleShape)
                    .border(1.dp, contentColor.copy(alpha = 0.3f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = index.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = contentColor
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = text,
                fontSize = 17.sp,
                textAlign = TextAlign.Start,
                color = contentColor,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
