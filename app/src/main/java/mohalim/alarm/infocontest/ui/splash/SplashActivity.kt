package mohalim.alarm.infocontest.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
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
        subscribeObservers()
        viewModel.getDataFromGoogleSheet(BuildConfig.API_KEY, SHEET_ID)
    }

    private fun subscribeObservers() {
        viewModel.loadingProgress.observe(this) {
            Log.d("TAG", "subscribeObservers: "+it)
            if (it == null) return@observe

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

}