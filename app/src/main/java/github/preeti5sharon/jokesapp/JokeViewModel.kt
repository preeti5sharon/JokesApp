package github.preeti5sharon.jokesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(private val repository: JokeRepository) : ViewModel() {
    private var _jokeList = MutableStateFlow<List<JokeResponseItem>?>(emptyList())
    val jokeList = _jokeList.asStateFlow()
    fun getJokes() = viewModelScope.launch(Dispatchers.IO) {
        _jokeList.value = repository.getJokes().body()
    }
}
