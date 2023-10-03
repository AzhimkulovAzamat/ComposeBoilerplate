package net.breez.composeboilerplate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import net.breez.domain.UIState
import net.breez.domain.interactor.FetchPersonalizedData
import net.breez.domain.model.ProfileModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val fetchPersonalizedData: FetchPersonalizedData
): ViewModel() {
    val profileModel = MutableStateFlow<UIState<ProfileModel>>(UIState.Loading)

    fun fetchPersonalData() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchPersonalizedData.execute().collect {
                profileModel.value = it
            }
        }
    }
}