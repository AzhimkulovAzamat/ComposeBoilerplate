package net.breez.composeboilerplate.mvi.signin

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.breez.composeboilerplate.mvi.redux.Action
import net.breez.composeboilerplate.mvi.redux.Bootstrapper
import net.breez.composeboilerplate.mvi.redux.Command
import net.breez.composeboilerplate.mvi.redux.Event
import net.breez.composeboilerplate.mvi.redux.LoggerImpl
import net.breez.composeboilerplate.mvi.redux.MiddlewareContainer
import net.breez.composeboilerplate.mvi.redux.PostProcessorContainer
import net.breez.composeboilerplate.mvi.redux.Store
import net.breez.composeboilerplate.ui.RegistrationCommand
import net.breez.composeboilerplate.ui.RegistrationEvent
import net.breez.composeboilerplate.ui.RegistrationMiddleWare
import net.breez.composeboilerplate.viewmodel.BaseViewModel
import net.breez.data.repositories.ProfileDataRepository
import net.breez.domain.interactor.FlowResult
import net.breez.domain.repositories.ProfileRepository
import net.breez.domain.repositories.RegistrationRepository
import javax.inject.Inject

@HiltViewModel
class PhoneInputViewModel @Inject constructor(
    private val registrationMiddleWare: RegistrationMiddleWare,
    private val phoneInputPostProcessor: PhoneInputPostProcessor,
    phoneInputBootstrapper: PhoneInputBootstrapper,
    reducer: PhoneInputReducer
) : BaseViewModel<PhoneInputState>() {

    private val loginMiddlewares = object : MiddlewareContainer {

        override suspend fun process(command: Command): Event {
            return when (command) {
                is RegistrationCommand -> registrationMiddleWare.process(command)
                else -> defaultEvent()
            }
        }
    }

    private val loginPostProcessors = object : PostProcessorContainer {

        override suspend fun process(event: Event): Action? {
            return when (event) {
                is RegistrationEvent -> phoneInputPostProcessor.process(event)
                else -> defaultAction()
            }
        }
    }

    private val store = Store(
        initialState = PhoneInputState(),
        reducer = reducer,
        logger = LoggerImpl(),
        bootstrapper = phoneInputBootstrapper,
        middlewares = loginMiddlewares,
        postProcessors = loginPostProcessors
    )

    override val state = store.state
    val viewEffect = store.viewEffect

    override fun onCreate() {
        super.onCreate()
        viewModelScope.launch {
            store.loadData()
        }
    }

    fun sendAction(action: PhoneInputAction) {
        viewModelScope.launch {
            store.dispatch(action)
        }
    }
}

class PhoneInputBootstrapper @Inject constructor(
    private val registrationRepository: RegistrationRepository
) : Bootstrapper<PhoneInputAction> {
    override suspend fun viewDidLoad(newAction: suspend (PhoneInputAction) -> Unit) {
//        when (val result = registrationRepository.getCaptcha()) {
//            is FlowResult.Exception -> PhoneInputAction.FetchingCaptchaFailed(result.throwable)
//            is FlowResult.Success -> PhoneInputAction.FetchingCaptchaSucceeded(result.element)
//        }
    }
}

