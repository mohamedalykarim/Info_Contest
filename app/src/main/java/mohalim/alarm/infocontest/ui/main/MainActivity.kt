package mohalim.alarm.infocontest.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.databinding.ActivityMainBinding
import mohalim.alarm.infocontest.ui.admin.AdminActivity
import mohalim.alarm.infocontest.ui.login.LoginActivity
import mohalim.alarm.infocontest.ui.quiz.QuizActivity


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val QUIZ_TYPE: String = "quiz_type"
    val viewModel : HomeViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding;




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        clicks()




    }


    override fun onResume() {
        super.onResume()

        binding.capitalsContainer.isClickable = true
        binding.historyContainer.isClickable = true
        binding.geographyContainer.isClickable = true
        binding.literatureContainer.isClickable = true
        binding.sportsContainer.isClickable = true
        binding.scienceContainer.isClickable = true


    }

    private fun clicks() {
        binding.capitalsContainer.setOnClickListener {
            binding.capitalsContainer.isClickable = false
            startTheQuiz(1)
        }

        binding.historyContainer.setOnClickListener {
            binding.historyContainer.isClickable = false
            startTheQuiz(2)
        }

        binding.geographyContainer.setOnClickListener {
            binding.geographyContainer.isClickable = false
            startTheQuiz(3)
        }

        binding.literatureContainer.setOnClickListener {
            binding.literatureContainer.isClickable = false
            startTheQuiz(4)
        }

        binding.sportsContainer.setOnClickListener {
            binding.sportsContainer.isClickable = false
            startTheQuiz(5)
        }

        binding.scienceContainer.setOnClickListener {
            binding.scienceContainer.isClickable = false
            startTheQuiz(6)
        }

        binding.login.setOnClickListener {
            val intent : Intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.admin.setOnClickListener {
            val intent : Intent = Intent(this@MainActivity, AdminActivity::class.java)
            startActivity(intent)
        }

    }


    private fun startTheQuiz(type: Int) {
        val intent : Intent = Intent(this@MainActivity, QuizActivity::class.java)
        intent.putExtra(QUIZ_TYPE, type)
        startActivity(intent)

    }


}