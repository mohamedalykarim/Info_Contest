package mohalim.alarm.infocontest.ui.add_question

import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddQuestionActivity : AppCompatActivity() {
    val viewModel : AddQuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AddQuestionUI(viewModel, this) }
    }
}

@Composable
fun AddQuestionUI(viewModel: AddQuestionViewModel, addQuestionActivity: AddQuestionActivity) {
    var questionType by remember { mutableStateOf(TextFieldValue("")) }
    var questionText by remember { mutableStateOf(TextFieldValue("")) }
    var answer1 by remember { mutableStateOf(TextFieldValue("")) }
    var answer2 by remember { mutableStateOf(TextFieldValue("")) }
    var answer3 by remember { mutableStateOf(TextFieldValue("")) }
    var answer4 by remember { mutableStateOf(TextFieldValue("")) }
    var correctAnswer by remember { mutableStateOf(TextFieldValue("")) }
    var comment by remember { mutableStateOf(TextFieldValue("")) }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.linearGradient(
                colors = listOf(
                    Color(parseColor("#564ce9")),
                    Color(parseColor("#b66cb6")),
                ),
            )
        ))

    {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        )

        {

            Text(
                text = "Add New Question !!",
                Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .fillMaxWidth(),
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp
            )

            var expanded by remember { mutableStateOf(false) }
            val list = listOf("Capitals", "History", "Geography", "Literature", "Sports", "Science")
            var selectedItem by remember { mutableStateOf("") }
            var textFieldSize by remember { mutableStateOf(Size.Zero) }

            val icon = if (expanded) {
                Icons.Filled.KeyboardArrowUp
            } else {
                Icons.Filled.KeyboardArrowDown
            }

            Column(
                modifier = Modifier.padding(10.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = selectedItem,
                    onValueChange = { it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    label = { Text(text = "Question type") },
                    trailingIcon = {
                        Icon(icon, "", Modifier.clickable { expanded = !expanded })
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(android.graphics.Color.parseColor("#ffffff")),
                        focusedIndicatorColor = Color(android.graphics.Color.parseColor("#da9f09")),
                        focusedLabelColor = Color(android.graphics.Color.parseColor("#313131")),
                    ),

                    )


                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                )
                {
                    list.forEach { label ->
                        DropdownMenuItem(onClick = {
                            selectedItem = label
                            expanded = false
                        })
                        {

                            Text(text = label)

                        }
                    }

                }

                OutlinedTextField(
                    value = questionText,
                    onValueChange = { questionText = it },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(android.graphics.Color.parseColor("#ffffff")),
                        focusedIndicatorColor = Color(android.graphics.Color.parseColor("#da9f09")),
                        focusedLabelColor = Color(android.graphics.Color.parseColor("#313131")),
                    ),
                    label = { Text("Question Text") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                    ),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Newspaper, contentDescription = null)
                    }
                )

                OutlinedTextField(
                    value = answer1,
                    onValueChange = { answer1 = it },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(android.graphics.Color.parseColor("#ffffff")),
                        focusedIndicatorColor = Color(android.graphics.Color.parseColor("#da9f09")),
                        focusedLabelColor = Color(android.graphics.Color.parseColor("#313131")),
                    ),
                    label = { Text("Answer One") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Newspaper, contentDescription = null)
                    }
                )

                OutlinedTextField(
                    value = answer2,
                    onValueChange = { answer2 = it },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(android.graphics.Color.parseColor("#ffffff")),
                        focusedIndicatorColor = Color(android.graphics.Color.parseColor("#da9f09")),
                        focusedLabelColor = Color(android.graphics.Color.parseColor("#313131")),
                    ),
                    label = { Text("Answer Two") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Newspaper, contentDescription = null)
                    }
                )

                OutlinedTextField(
                    value = answer3,
                    onValueChange = { answer3 = it },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(android.graphics.Color.parseColor("#ffffff")),
                        focusedIndicatorColor = Color(android.graphics.Color.parseColor("#da9f09")),
                        focusedLabelColor = Color(android.graphics.Color.parseColor("#313131")),
                    ),
                    label = { Text("Answer Three") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Newspaper, contentDescription = null)
                    }
                )

                OutlinedTextField(
                    value = answer4,
                    onValueChange = { answer4 = it },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(android.graphics.Color.parseColor("#ffffff")),
                        focusedIndicatorColor = Color(android.graphics.Color.parseColor("#da9f09")),
                        focusedLabelColor = Color(android.graphics.Color.parseColor("#313131")),
                    ),
                    label = { Text("Answer Four") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Newspaper, contentDescription = null)
                    }
                )

                OutlinedTextField(
                    value = comment,
                    onValueChange = { comment = it },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(android.graphics.Color.parseColor("#ffffff")),
                        focusedIndicatorColor = Color(android.graphics.Color.parseColor("#da9f09")),
                        focusedLabelColor = Color(android.graphics.Color.parseColor("#313131")),
                    ),
                    label = { Text("Comment") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Newspaper, contentDescription = null)
                    }
                )


                val options = listOf(
                    "Answer one",
                    "Answer Two",
                    "Answer Three",
                    "Answer Four",
                )
                var selectedOption by remember {
                    mutableStateOf("")
                }
                val onSelectionChange = { text: String ->
                    selectedOption = text
                }

                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    options.forEach { text ->
                        Row(
                            modifier = Modifier
                                .padding(
                                    all = 3.dp,
                                ),
                        ) {
                            Text(
                                text = text,
                                style = typography.body1.merge(),
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .width(200.dp)
                                    .clip(
                                        shape = RoundedCornerShape(
                                            size = 12.dp,
                                        ),
                                    )
                                    .clickable {
                                        onSelectionChange(text)
                                    }
                                    .background(
                                        if (text == selectedOption) {
                                            Color(parseColor("#313131"))
                                        } else {
                                            Color.LightGray
                                        }
                                    )
                                    .padding(
                                        vertical = 5.dp,
                                        horizontal = 5.dp,
                                    ),
                            )
                        }
                    }
                }

                Button(
                    onClick = {
                        //your onclick code here
                    }, elevation = ButtonDefaults.elevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 15.dp,
                        disabledElevation = 0.dp
                    )
                ) {
                    Text(text = "Add Question")
                }
            }


        }

    }
}
