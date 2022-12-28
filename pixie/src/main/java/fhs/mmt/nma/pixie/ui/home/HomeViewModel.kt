package fhs.mmt.nma.pixie.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fhs.mmt.nma.pixie.data.Post
import fhs.mmt.nma.pixie.samples.AllPosts
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val posts: MutableState<List<Post>> = mutableStateOf(emptyList())

    fun onPostChanged(sender: Post) {

    }
    init {
        viewModelScope.launch {
            //posts.value = AllPosts
            repeat(AllPosts.size) {
                delay(1000)
                posts.value = AllPosts.take(it)
            }
        }
    }
}