package mohalim.alarm.infocontest.core.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("info_contest_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_QUESTIONS_COUNT = "questions_count"
        const val DEFAULT_QUESTIONS_COUNT = 25
    }

    fun getQuestionsCount(): Int {
        return sharedPreferences.getInt(KEY_QUESTIONS_COUNT, DEFAULT_QUESTIONS_COUNT)
    }

    fun setQuestionsCount(count: Int) {
        sharedPreferences.edit().putInt(KEY_QUESTIONS_COUNT, count).apply()
    }
}
