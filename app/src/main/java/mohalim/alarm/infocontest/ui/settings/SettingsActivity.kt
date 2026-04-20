package mohalim.alarm.infocontest.ui.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.core.utils.PreferencesManager
import mohalim.alarm.infocontest.ui.theme.InfoContestTheme
import javax.inject.Inject

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {
    @Inject
    lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfoContestTheme {
                SettingsScreen(
                    preferencesManager = preferencesManager,
                    onBackClick = { finish() }
                )
            }
        }
    }
}

@Composable
fun SettingsScreen(preferencesManager: PreferencesManager, onBackClick: () -> Unit) {
    val options = listOf(10, 20, 25, 40, 50)
    var selectedCount by remember { mutableIntStateOf(preferencesManager.getQuestionsCount()) }

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
                    title = { Text("الإعدادات", fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    backgroundColor = Color.Transparent,
                    contentColor = Color.White,
                    elevation = 0.dp
                )
            },
            backgroundColor = Color.Transparent
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = 4.dp,
                    backgroundColor = Color.White.copy(alpha = 0.1f)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "عدد الأسئلة في كل اختبار:",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        options.forEach { count ->
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = (count == selectedCount),
                                        onClick = {
                                            selectedCount = count
                                            preferencesManager.setQuestionsCount(count)
                                        }
                                    )
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = (count == selectedCount),
                                    onClick = {
                                        selectedCount = count
                                        preferencesManager.setQuestionsCount(count)
                                    },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.White,
                                        unselectedColor = Color.White.copy(alpha = 0.6f)
                                    )
                                )
                                Text(
                                    text = "$count سؤال",
                                    color = Color.White,
                                    modifier = Modifier.padding(start = 8.dp),
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
