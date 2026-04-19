package mohalim.alarm.infocontest.ui.other_topics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mohalim.alarm.infocontest.core.data_source.room.QuestionDao
import javax.inject.Inject

@HiltViewModel
class OtherTopicsViewModel @Inject constructor(
    private val questionDao: QuestionDao
) : ViewModel() {

    private val _categories = MutableStateFlow<List<Int>>(emptyList())
    val categories: StateFlow<List<Int>> = _categories

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            // Get all categories and filter out the main ones (1 to 6)
            val allCats = questionDao.getAllCategories()
            val otherCats = allCats.filter { it > 6 }
            _categories.value = otherCats
        }
    }
}
