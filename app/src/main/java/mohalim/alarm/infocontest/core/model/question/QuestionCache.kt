package mohalim.alarm.infocontest.core.model.question

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class QuestionCache(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int,

    @ColumnInfo(name = "type")
    var type : Int,

    @ColumnInfo(name = "question_text")
    var questionText : String,

    @ColumnInfo(name = "answer1")
    var answer1 : String,

    @ColumnInfo(name = "answer2")
    var answer2 : String,

    @ColumnInfo(name = "answer3")
    var answer3 : String,

    @ColumnInfo(name = "answer4")
    var answer4 : String,

    @ColumnInfo(name = "answer5")
    var answer5 : String,

    @ColumnInfo(name = "correct_answer")
    var correctAnswer : String,

    @ColumnInfo(name = "extra_info")
    var extraInfo : String
)
