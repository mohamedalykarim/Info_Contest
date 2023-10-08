package mohalim.alarm.infocontest.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_result)

        if (!intent.hasExtra("CORRECT") || !intent.hasExtra("WRONG")){
            return
        }

        val correct = intent.getIntExtra("CORRECT",0)
        val wrong = intent.getIntExtra("WRONG",0)
        val allCount = correct + wrong

        val result : Double = (correct.toDouble() / allCount.toDouble()) * 100

        if(result < 60){
            binding.img.setImageResource(R.drawable.failed_icon)
        }

        binding.resultTV.text = result.toInt().toString() + "%"
        binding.correctTv.text = correct.toString()
        binding.wrongTv.text = wrong.toString()

    }

}