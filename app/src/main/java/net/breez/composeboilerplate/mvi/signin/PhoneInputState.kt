package net.breez.composeboilerplate.mvi.signin

import com.google.gson.annotations.Expose
import net.breez.composeboilerplate.model.PhoneNumberMasks
import net.breez.composeboilerplate.mvi.redux.Command
import net.breez.composeboilerplate.mvi.redux.OneShotEvent
import net.breez.composeboilerplate.mvi.redux.State
import net.breez.composeboilerplate.mvi.redux.UndefinedCommand
import net.breez.domain.model.ProfileModel

data class PhoneInputState(
    val isLoading: Boolean = false,
    val exception: Throwable? = null,
    val country: PhoneNumberMasks = PhoneNumberMasks.KG,
    val phoneNumber: String = "",
    @Expose(deserialize = false)
    val password: String = "",
    val showCountrySelectDialog: Boolean = false,
    val profileModel: ProfileModel? = null
): State