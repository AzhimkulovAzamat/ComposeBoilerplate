package net.breez.composeboilerplate.ui

import net.breez.composeboilerplate.mvi.redux.Command
import net.breez.composeboilerplate.mvi.redux.Event
import net.breez.composeboilerplate.mvi.redux.Middleware
import net.breez.domain.interactor.FlowResult
import net.breez.domain.model.ProfileModel
import net.breez.domain.repositories.ProfileRepository
import javax.inject.Inject

class RegistrationMiddleWare @Inject constructor(
    private val profileRepository: ProfileRepository
) : Middleware<RegistrationEvent, RegistrationCommand> {

    override suspend fun process(command: RegistrationCommand): RegistrationEvent {
        return when (command) {
            is RegistrationCommand.SignIn -> {
                when (val result = profileRepository.getOnlyProfile()) {
                    is FlowResult.Success -> RegistrationEvent.SuccessSignIn(result.element)
                    is FlowResult.Exception -> RegistrationEvent.FailedSignIn(result.throwable)
                }
            }
        }
    }
}

sealed class RegistrationEvent : Event {
    class SuccessSignIn(val profileModel: ProfileModel) : RegistrationEvent()
    class FailedSignIn(val throwable: Throwable) : RegistrationEvent()
}

sealed class RegistrationCommand : Command {
    class SignIn(val phoneNumber: String, val password: String) : RegistrationCommand()
}