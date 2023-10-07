package mohalim.alarm.infocontest.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import mohalim.alarm.infocontest.BuildConfig
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

    companion object{
        const val SHEET_ID = "1Cbxmze6bIsyse-enXd-vjqZUoC8NcwPNYlPzW07LZQU"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        retrieveDataToSqliteDatabase()
        viewModel.getDataFromGoogleSheet(BuildConfig.API_KEY, SHEET_ID)
    }

    private fun subscribeObservers() {
        viewModel.loadingProgress.observe(this) {
            Log.d("TAG", "subscribeObservers: "+it)
            if (it == null) return@observe

            if (it.isNotEmpty()){
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val counter = object : CountDownTimer(1000,1000){
                    override fun onTick(p0: Long) {
                    }

                    override fun onFinish() {
                        retrieveDataToSqliteDatabase()
                    }

                }
                counter.start()

            }



        }
    }

    private fun retrieveDataToSqliteDatabase() {
        viewModel.retrieveDataToSqliteDatabase(this)
    }
}