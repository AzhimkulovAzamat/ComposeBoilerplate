package net.breez.composeboilerplate.mvi.splash

import net.breez.composeboilerplate.mvi.redux.State
import net.breez.domain.model.ProfileModel

data class SplashState(
    val profileModel: ProfileModel? = null
): State
