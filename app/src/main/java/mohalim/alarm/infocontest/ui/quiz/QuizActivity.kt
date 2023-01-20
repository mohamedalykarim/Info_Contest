package mohalim.alarm.infocontest.ui.quiz

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.databinding.ActivityQuizBinding
import mohalim.alarm.infocontest.ui.result.ResultActivity

@AndroidEntryPoint
class QuizActivity : AppCompatActivity() {
    private val QUIZ_TYPE: String = "quiz_type"
    val viewModel : QuizViewModel by viewModels()
    private lateinit var timer : CountDownTimer
    lateinit var binding : ActivityQuizBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz)
        binding.setLifecycleOwner { this@QuizActivity.lifecycle }



        val type =  intent.getIntExtra(QUIZ_TYPE, 1)
        binding.viewmodel = viewModel

        initTitle(type)
        clicks()

        viewModel.retrieveQuestionForQuiz(type, binding, this)


    }

    private fun initTitle(type: Int) {
        when (type) {
            1 -> {
                binding.titleTv.text = "العواصم"
            }
            2 -> {
                binding.titleTv.text = "التاريخ"
            }
            3 -> {
                binding.titleTv.text = "الجغرافيا"
            }
            4 -> {
                binding.titleTv.text = "الأدب"
            }
            5 -> {
                binding.titleTv.text = "الرياضة"
            }
            6 -> {
                binding.titleTv.text = "العلوم"
            }
        }
    }

    private fun clicks() {
        binding.choice1Btn.setOnClickListener {
            binding.choice1Btn.isClickable = false
            binding.choice2Btn.isClickable = false
            binding.choice3Btn.isClickable = false
            binding.choice4Btn.isClickable = false
            binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_4)

            var mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.button_answer)

            if (viewModel.isAudioEnabled){
                mediaPlayer.start()
                mediaPlayer.setOnCompletionListener {
                    mediaPlayer.stop()
                    mediaPlayer.release()
                }
            }


            // Correct Answer
            if(binding.choice1Text.text.toString() == viewModel.currentQuestion.correctAnswer){
                timer = object : CountDownTimer(2000,100){
                    override fun onTick(millisUntilFinished: Long) {
                        if (millisUntilFinished in 301..399){
                            binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)

                            if (viewModel.isAudioEnabled) {
                                mediaPlayer =
                                    MediaPlayer.create(this@QuizActivity, R.raw.correct_answer)
                                mediaPlayer.start()
                                mediaPlayer.setOnCompletionListener {
                                    mediaPlayer.stop()
                                    mediaPlayer.release()
                                }
                            }

                        } else if (millisUntilFinished in 201..299){
                            binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_3)
                        }else if (millisUntilFinished in 101..199){
                            binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)

                        }
                     }

                    override fun onFinish() {
                        viewModel.currentQuestion.isAnswered = true
                    }

                }
                timer.start()
                viewModel.correctAnswersCount++


            }
            // Wrong Answer
            else{

                timer = object : CountDownTimer(2000,100){
                    override fun onTick(millisUntilFinished: Long) {
                        if (millisUntilFinished in 301..399){
                            binding.choice1Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_wrong_answer)

                            if(viewModel.isAudioEnabled){
                                mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.wrong_answer)
                                mediaPlayer.start()
                                mediaPlayer.setOnCompletionListener {
                                    mediaPlayer.stop()
                                    mediaPlayer.release()
                                }
                            }

                        } else if (millisUntilFinished in 201..299){
                            binding.choice1Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_3)
                        }else if (millisUntilFinished in 101..199){
                            binding.choice1Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_wrong_answer)
                        }
                    }

                    override fun onFinish() {

                        when (viewModel.currentQuestion.correctAnswer) {
                            binding.choice2Text.text.toString() -> {
                                binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                            binding.choice3Text.text.toString() -> {
                                binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                            binding.choice4Text.text.toString() -> {
                                binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                        }

                        viewModel.currentQuestion.isAnswered = true
                    }

                }
                timer.start()
                viewModel.wrongAnswersCount++


            }




        }

        binding.choice2Btn.setOnClickListener {
            binding.choice1Btn.isClickable = false
            binding.choice2Btn.isClickable = false
            binding.choice3Btn.isClickable = false
            binding.choice4Btn.isClickable = false
            binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_4)

            var mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.button_answer)

            if (viewModel.isAudioEnabled){
                mediaPlayer.start()
                mediaPlayer.setOnCompletionListener {
                    mediaPlayer.stop()
                    mediaPlayer.release()
                }
            }

            // Correct Answer
            if(binding.choice2Text.text.toString() == viewModel.currentQuestion.correctAnswer){



                timer = object : CountDownTimer(2000,100){
                    override fun onTick(millisUntilFinished: Long) {
                        if (millisUntilFinished in 301..399){
                            binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)

                            if (viewModel.isAudioEnabled){
                                mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.correct_answer)
                                mediaPlayer.start()
                                mediaPlayer.setOnCompletionListener {
                                    mediaPlayer.stop()
                                    mediaPlayer.release()
                                }
                            }

                        } else if (millisUntilFinished in 201..299){
                            binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_3)
                        }else if (millisUntilFinished in 101..199){
                            binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                        }
                    }

                    override fun onFinish() {
                        viewModel.currentQuestion.isAnswered = true
                    }

                }
                timer.start()
                viewModel.correctAnswersCount++
            }
            // Wrong Answer
            else{



                timer = object : CountDownTimer(2000,100){
                    override fun onTick(millisUntilFinished: Long) {
                        if (millisUntilFinished in 301..399){
                            binding.choice2Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_wrong_answer)

                            if (viewModel.isAudioEnabled){
                                mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.wrong_answer)
                                mediaPlayer.start()
                                mediaPlayer.setOnCompletionListener {
                                    mediaPlayer.stop()
                                    mediaPlayer.release()
                                }
                            }

                        } else if (millisUntilFinished in 201..299){
                            binding.choice2Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_3)
                        }else if (millisUntilFinished in 101..199){
                            binding.choice2Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_wrong_answer)
                        }
                    }

                    override fun onFinish() {
                        when (viewModel.currentQuestion.correctAnswer) {
                            binding.choice1Text.text.toString() -> {
                                binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                            binding.choice3Text.text.toString() -> {
                                binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                            binding.choice4Text.text.toString() -> {
                                binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                        }

                        viewModel.currentQuestion.isAnswered = true
                    }

                }
                timer.start()
                viewModel.wrongAnswersCount++
            }
        }

        binding.choice3Btn.setOnClickListener {
            binding.choice1Btn.isClickable = false
            binding.choice2Btn.isClickable = false
            binding.choice3Btn.isClickable = false
            binding.choice4Btn.isClickable = false
            binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_4)

            var mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.button_answer)

            if (viewModel.isAudioEnabled){
                mediaPlayer.start()
                mediaPlayer.setOnCompletionListener {
                    mediaPlayer.stop()
                    mediaPlayer.release()
                }
            }

            // Correct Answer
            if(binding.choice3Text.text.toString() == viewModel.currentQuestion.correctAnswer){



                timer = object : CountDownTimer(2000,100){
                    override fun onTick(millisUntilFinished: Long) {
                        if (millisUntilFinished in 301..399){
                            binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)

                            if (viewModel.isAudioEnabled){
                                mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.correct_answer)
                                mediaPlayer.start()
                                mediaPlayer.setOnCompletionListener {
                                    mediaPlayer.stop()
                                    mediaPlayer.release()
                                }
                            }

                        } else if (millisUntilFinished in 201..299){
                            binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_3)
                        }else if (millisUntilFinished in 101..199){
                            binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                        }
                    }

                    override fun onFinish() {
                        viewModel.currentQuestion.isAnswered = true
                    }

                }
                timer.start()
                viewModel.correctAnswersCount++
            }
            // Wrong Answer
            else{

                timer = object : CountDownTimer(2000,100){
                    override fun onTick(millisUntilFinished: Long) {
                        if (millisUntilFinished in 301..399){
                            binding.choice3Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_wrong_answer)

                            if (viewModel.isAudioEnabled){
                                mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.wrong_answer)
                                mediaPlayer.start()
                                mediaPlayer.setOnCompletionListener {
                                    mediaPlayer.stop()
                                    mediaPlayer.release()
                                }
                            }

                        } else if (millisUntilFinished in 201..299){
                            binding.choice3Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_3)
                        }else if (millisUntilFinished in 101..199){
                            binding.choice3Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_wrong_answer)
                        }
                    }

                    override fun onFinish() {
                        when (viewModel.currentQuestion.correctAnswer) {
                            binding.choice1Text.text.toString() -> {
                                binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                            binding.choice2Text.text.toString() -> {
                                binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                            binding.choice4Text.text.toString() -> {
                                binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                        }

                        viewModel.currentQuestion.isAnswered = true
                    }

                }
                timer.start()
                viewModel.wrongAnswersCount++

            }
        }

        binding.choice4Btn.setOnClickListener {
            binding.choice1Btn.isClickable = false
            binding.choice2Btn.isClickable = false
            binding.choice3Btn.isClickable = false
            binding.choice4Btn.isClickable = false
            binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_4)


            var mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.button_answer)

            if (viewModel.isAudioEnabled){
                mediaPlayer.start()
                mediaPlayer.setOnCompletionListener {
                    mediaPlayer.stop()
                    mediaPlayer.release()
                }
            }

            // Correct Answer
            if(binding.choice4Text.text.toString() == viewModel.currentQuestion.correctAnswer){



                timer = object : CountDownTimer(2000,100){
                    override fun onTick(millisUntilFinished: Long) {
                        if (millisUntilFinished in 301..399){
                            binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)

                            if (viewModel.isAudioEnabled){
                                mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.correct_answer)
                                mediaPlayer.start()
                                mediaPlayer.setOnCompletionListener {
                                    mediaPlayer.stop()
                                    mediaPlayer.release()
                                }
                            }

                        } else if (millisUntilFinished in 201..299){
                            binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_3)
                        }else if (millisUntilFinished in 101..199){
                            binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                        }
                    }

                    override fun onFinish() {
                        viewModel.currentQuestion.isAnswered = true
                    }

                }
                timer.start()
                viewModel.correctAnswersCount++
            }
            // Wrong Answer
            else{



                timer = object : CountDownTimer(2000,100){
                    override fun onTick(millisUntilFinished: Long) {
                        if (millisUntilFinished in 301..399){
                            binding.choice4Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_wrong_answer)

                            if (viewModel.isAudioEnabled){
                                mediaPlayer = MediaPlayer.create(this@QuizActivity, R.raw.wrong_answer)
                                mediaPlayer.start()
                                mediaPlayer.setOnCompletionListener {
                                    mediaPlayer.stop()
                                    mediaPlayer.release()
                                }
                            }

                        } else if (millisUntilFinished in 201..299){
                            binding.choice4Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_3)
                        }else if (millisUntilFinished in 101..199){
                            binding.choice4Text.setTextColor(Color.parseColor("#ffffff"))
                            binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_wrong_answer)
                        }
                    }

                    override fun onFinish() {

                        when (viewModel.currentQuestion.correctAnswer) {
                            binding.choice1Text.text.toString() -> {
                                binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                            binding.choice2Text.text.toString() -> {
                                binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                            binding.choice3Text.text.toString() -> {
                                binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_correct_answer)
                            }
                        }

                        viewModel.currentQuestion.isAnswered = true
                    }

                }
                timer.start()
                viewModel.wrongAnswersCount++
            }
        }

        binding.nextBtn.setOnClickListener {
            if (!viewModel.currentQuestion.isAnswered){
                return@setOnClickListener
            }

            if (viewModel.currentQuestionNumber == 25 ){
                val intent = Intent(this@QuizActivity,  ResultActivity::class.java)
                intent.putExtra("CORRECT", viewModel.correctAnswersCount)
                intent.putExtra("WRONG", viewModel.wrongAnswersCount)

                finish()
                startActivity(intent)

                return@setOnClickListener
            }

            if (viewModel.currentQuestionNumber == 24 ){
                binding.nextBtn.text = "النتيجة"
            }

            viewModel.currentQuestion = viewModel.questions[viewModel.currentQuestionNumber]
            viewModel.currentQuestionNumber++
            binding.invalidateAll()

            binding.choice1Btn.isClickable = true
            binding.choice2Btn.isClickable = true
            binding.choice3Btn.isClickable = true
            binding.choice4Btn.isClickable = true

            binding.choice1Btn.setBackgroundResource(R.drawable.rounded_shape_3)
            binding.choice2Btn.setBackgroundResource(R.drawable.rounded_shape_3)
            binding.choice3Btn.setBackgroundResource(R.drawable.rounded_shape_3)
            binding.choice4Btn.setBackgroundResource(R.drawable.rounded_shape_3)

            binding.choice1Text.setTextColor(Color.parseColor("#642ea8"))
            binding.choice2Text.setTextColor(Color.parseColor("#642ea8"))
            binding.choice3Text.setTextColor(Color.parseColor("#642ea8"))
            binding.choice4Text.setTextColor(Color.parseColor("#642ea8"))

            timer.cancel()

        }

        binding.audioBtn.setOnClickListener {
            if (viewModel.isAudioEnabled){
                viewModel.isAudioEnabled = false
                binding.audioBtn.setImageResource(R.drawable.audio_not_active)
            }else{
                viewModel.isAudioEnabled = true
                binding.audioBtn.setImageResource(R.drawable.audio_active)
            }
        }

    }
}