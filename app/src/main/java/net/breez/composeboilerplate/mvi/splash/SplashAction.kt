package net.breez.composeboilerplate.mvi.splash

import net.breez.composeboilerplate.mvi.redux.Action
import net.breez.domain.model.ProfileModel

sealed class SplashAction: Action {
    class FetchUserSucceeded(val profileModel: ProfileModel): SplashAction()
    class FetchUserFailed(val throwable: Throwable): SplashAction()
}