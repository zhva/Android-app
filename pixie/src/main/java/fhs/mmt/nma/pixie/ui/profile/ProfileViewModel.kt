package fhs.mmt.nma.pixie.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fhs.mmt.nma.pixie.data.Photographer
import fhs.mmt.nma.pixie.data.ProfileInfo
import fhs.mmt.nma.pixie.samples.CurrentProfileInfo
import fhs.mmt.nma.pixie.samples.providers.ProfileInfoProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel() {
    val userProfile: MutableState<ProfileInfo> = mutableStateOf(ProfileInfo())

    fun onProfileChanged(sender: ProfileInfo) {
    }
    init {
        viewModelScope.launch {
            userProfile.value = CurrentProfileInfo
        }
    }
}