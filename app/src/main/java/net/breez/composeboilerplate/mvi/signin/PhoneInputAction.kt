package net.breez.composeboilerplate.mvi.signin

import net.breez.composeboilerplate.model.PhoneNumberMasks
import net.breez.composeboilerplate.mvi.redux.Action
import net.breez.composeboilerplate.ui.custom.SnackbarOptions
import net.breez.domain.interactor.FlowResult
import net.breez.domain.model.CaptchaModel
import net.breez.domain.model.ProfileModel

sealed class PhoneInputAction : Action {
    object ShowCountryOptions : PhoneInputAction()
    class SelectedCountry(val phoneNumberMasks: PhoneNumberMasks) : PhoneInputAction()
    class PhoneNumberInserted(val actualValue: String) : PhoneInputAction()
    class PasswordInserted(val actualValue: String) : PhoneInputAction()
    object SubmitPhoneAndPassword : PhoneInputAction()
    class SignInConfirmed(val profileModel: ProfileModel) : PhoneInputAction()
    class SignInFailed(val throwable: Throwable) : PhoneInputAction()
    class FetchingCaptchaSucceeded(val captchaModel: CaptchaModel): PhoneInputAction()
    class FetchingCaptchaFailed(val throwable: Throwable): PhoneInputAction()
    object UserCloseBottomSheet: PhoneInputAction()
}
