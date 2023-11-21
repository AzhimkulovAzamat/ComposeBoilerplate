package net.breez.composeboilerplate.mvi.signin

import net.breez.composeboilerplate.mvi.redux.PostProcessor
import net.breez.composeboilerplate.ui.RegistrationEvent
import javax.inject.Inject

class PhoneInputPostProcessor @Inject constructor(): PostProcessor<RegistrationEvent, PhoneInputAction> {
    override fun process(event: RegistrationEvent): PhoneInputAction {
        return when(event) {
            is RegistrationEvent.FailedSignIn -> PhoneInputAction.SignInFailed(event.throwable)
            is RegistrationEvent.SuccessSignIn -> PhoneInputAction.SignInConfirmed(event.profileModel)
        }
    }
}