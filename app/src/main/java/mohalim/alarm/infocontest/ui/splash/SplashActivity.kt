package mohalim.alarm.infocontest.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.core.utils.IPreferenceHelper
import mohalim.alarm.infocontest.core.utils.PreferencesUtils
import mohalim.alarm.infocontest.databinding.ActivitySplashBinding
import mohalim.alarm.infocontest.ui.main.MainActivity

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    val viewModel : SplashViewModel by viewModels()
    lateinit var binding : ActivitySplashBinding

    private val preferenceHelper: IPreferenceHelper by lazy { PreferencesUtils(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        val isFirstOpen = preferenceHelper.getIsFirstOpen()

        if (!isFirstOpen){
            retrieveDataToSqliteDatabase()
            preferenceHelper.setIsFirstOpen(true)
        }else{
            val timer = object : CountDownTimer(1000,1000){
                override fun onTick(millisUntilFinished: Long) {}

                override fun onFinish() {
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }

            timer.start()
        }

        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.loadingProgress.observe(this) {
            if (it == 100) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun retrieveDataToSqliteDatabase() {
        viewModel.retrieveDataToSqliteDatabase(this)
    }
}