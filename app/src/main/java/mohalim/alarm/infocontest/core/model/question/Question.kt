package mohalim.alarm.infocontest.core.model.question

data class Question(
    var id : String,
    var type: Int,
    var questionText : String,
    var answer1 : String,
    var answer2 : String,
    var answer3 : String,
    var answer4 : String,
    var correctAnswer : String,
    var comment : String,
    var isAnswered : Boolean
)