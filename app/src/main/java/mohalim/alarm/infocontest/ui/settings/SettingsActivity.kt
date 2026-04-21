package mohalim.alarm.infocontest.ui.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                    title = {
                        Text(
                            "الإعدادات",
                            style = MaterialTheme.typography.h6.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "رجوع",
                                tint = Color.White
                            )
                        }
                    },
                    backgroundColor = Color.Transparent,
                    elevation = 0.dp
                )
            },
            backgroundColor = Color.Transparent
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                
                // Header section
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 32.dp)
                ) {
                    Surface(
                        color = Color.White.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "تخصيص التجربة",
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "قم بتعديل إعدادات المسابقة بما يناسبك",
                            style = MaterialTheme.typography.caption,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }

                // Question Count Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    elevation = 0.dp,
                    backgroundColor = Color.White.copy(alpha = 0.15f)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.Quiz,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "عدد الأسئلة في كل اختبار",
                                style = MaterialTheme.typography.subtitle1,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(20.dp))

                        options.forEach { count ->
                            val isSelected = count == selectedCount
                            
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(
                                        if (isSelected) Color.White.copy(alpha = 0.25f)
                                        else Color.Transparent
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = if (isSelected) Color.White else Color.White.copy(alpha = 0.1f),
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .clickable {
                                        selectedCount = count
                                        preferencesManager.setQuestionsCount(count)
                                    }
                                    .padding(16.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "$count سؤال",
                                        style = MaterialTheme.typography.body1,
                                        color = if (isSelected) Color.White else Color.White.copy(alpha = 0.7f),
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                    )
                                    
                                    RadioButton(
                                        selected = isSelected,
                                        onClick = null, // Handled by Box clickable
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = Color.White,
                                            unselectedColor = Color.White.copy(alpha = 0.4f)
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.weight(1f))
                
                Text(
                    text = "سيتم حفظ التغييرات تلقائياً",
                    style = MaterialTheme.typography.caption,
                    color = Color.White.copy(alpha = 0.6f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
