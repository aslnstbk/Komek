package com.aslnstbk.komek.help_need.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aslnstbk.komek.common.data.EMPTY_STRING
import com.aslnstbk.komek.common.data.models.HelpNeed
import com.aslnstbk.komek.common.data.models.PersonHelp
import com.aslnstbk.komek.help_need.domain.HelpNeedRepository
import com.aslnstbk.komek.navigation.NavigationState
import com.google.firebase.auth.FirebaseAuth

class HelpNeedViewModel(
    private val helpNeedRepository: HelpNeedRepository,
    private val firebaseAuth: FirebaseAuth,
) : ViewModel() {

    private val _helpNeedLiveData: MutableLiveData<HelpNeed> = MutableLiveData()
    private val _navigationLiveData: MutableLiveData<NavigationState> = MutableLiveData()

    val helpNeedLiveData: LiveData<HelpNeed> = _helpNeedLiveData
    val navigationLiveData: LiveData<NavigationState> = _navigationLiveData

    fun onStart(helpNeedId: String) {
        getHelpNeed(helpNeedId)
    }

    fun onHelp(
        helpNeedId: String,
        helpName: String,
        transmissionLetter: String,
    ) {
        val currentUser = firebaseAuth.currentUser!!
        val personHelp = PersonHelp(
            id = currentUser.uid,
            helpNeedId = helpNeedId,
            helpName = helpName,
            userName = currentUser.displayName ?: EMPTY_STRING,
            userPhoto = currentUser.photoUrl.toString(),
            transmissionLetter = transmissionLetter
        )

        helpNeedRepository.onHelp(
            personHelp = personHelp,
            onSuccess = {
                _navigationLiveData.value = NavigationState.Back
            },
            onFail = {}
        )
    }

    fun setNavigation(navigationState: NavigationState) {
        _navigationLiveData.value = navigationState
    }

    private fun getHelpNeed(helpNeedId: String) {
        helpNeedRepository.getHelpNeed(
            helpNeedId = helpNeedId,
            onSuccess = {
                _helpNeedLiveData.value = it
            },
            onFail = {}
        )
    }
}