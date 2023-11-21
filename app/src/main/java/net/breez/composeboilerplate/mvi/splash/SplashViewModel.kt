package net.breez.composeboilerplate.mvi.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import net.breez.composeboilerplate.mvi.redux.Bootstrapper
import net.breez.composeboilerplate.mvi.redux.LoggerImpl
import net.breez.composeboilerplate.mvi.redux.Store
import net.breez.domain.UIState
import net.breez.domain.interactor.FetchPersonalizedData
import net.breez.domain.model.ProfileModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val bootstrapper: SplashBootstrapper
) : ViewModel() {

    val store = Store(
        SplashState(),
        SplashReducer(),
        LoggerImpl()
    )
    val state = store.state
    val viewEffect = store.viewEffect

    fun loadData() {
        viewModelScope.launch {
            bootstrapper.run {

            }
        }
    }
}