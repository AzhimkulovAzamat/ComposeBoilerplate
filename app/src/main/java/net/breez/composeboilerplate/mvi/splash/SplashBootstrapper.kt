package net.breez.composeboilerplate.mvi.splash

import net.breez.composeboilerplate.mvi.redux.Bootstrapper
import net.breez.domain.interactor.FlowResult
import net.breez.domain.repositories.ProfileRepository
import javax.inject.Inject

class SplashBootstrapper @Inject constructor(
    private val profileRepository: ProfileRepository
) : Bootstrapper<SplashAction> {

    override suspend fun viewDidLoad(newAction: suspend (SplashAction) -> Unit) {
        newAction(
            when (val result = profileRepository.getOnlyProfile()) {
                is FlowResult.Success -> SplashAction.FetchUserSucceeded(result.element)
                is FlowResult.Exception -> SplashAction.FetchUserFailed(result.throwable)
            }
        )
    }
}