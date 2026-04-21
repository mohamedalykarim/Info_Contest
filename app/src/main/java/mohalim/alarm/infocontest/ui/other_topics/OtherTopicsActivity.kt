package mohalim.alarm.infocontest.ui.other_topics

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.ui.quiz.QuizActivity
import mohalim.alarm.infocontest.ui.theme.InfoContestTheme

@AndroidEntryPoint
class OtherTopicsActivity : AppCompatActivity() {
    private val viewModel: OtherTopicsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfoContestTheme {
                OtherTopicsScreen(
                    viewModel = viewModel,
                    onBackClick = { finish() },
                    onCategoryClick = { type ->
                        val intent = Intent(this, QuizActivity::class.java)
                        intent.putExtra("quiz_type", type)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun OtherTopicsScreen(
    viewModel: OtherTopicsViewModel,
    onBackClick: () -> Unit,
    onCategoryClick: (Int) -> Unit
) {
    val categories by viewModel.categories.collectAsState()

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
                    title = { Text("موضوعات أخرى", fontWeight = FontWeight.Bold) },
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
            if (categories.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize().padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    Text("لا توجد موضوعات أخرى حالياً", color = Color.White, fontSize = 18.sp)
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(padding)
                ) {
                    items(categories) { categoryType ->
                        OtherCategoryItem(
                            type = categoryType,
                            onClick = { onCategoryClick(categoryType) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun OtherCategoryItem(type: Int, onClick: () -> Unit) {
    val title = when(type){
        1 -> "المعلومات الدينية"
        2 -> "التاريخ"
        3 -> "الجغرافيا"
        4 -> "الأدب"
        5 -> "الرياضة"
        6 -> "العلوم"
        7 -> "العواصم"
        else -> "موضوع $type"
    }

    val iconRes = when(type){
        1 -> R.drawable.quran_icon
        2 -> R.drawable.history_icon
        3 -> R.drawable.geography_icon
        4 -> R.drawable.literature_icon
        5 -> R.drawable.sports_icon
        6 -> R.drawable.science_icon
        7 -> R.drawable.capital_icon
        else -> R.drawable.other
    }


    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color(0xFF62449A),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {


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
