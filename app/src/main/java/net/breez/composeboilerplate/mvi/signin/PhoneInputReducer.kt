package net.breez.composeboilerplate.mvi.signin

import net.breez.composeboilerplate.mvi.redux.OneShotEvent
import net.breez.composeboilerplate.mvi.redux.Reducer
import net.breez.composeboilerplate.mvi.redux.ReducerResult
import net.breez.composeboilerplate.mvi.redux.ToastEventData
import net.breez.composeboilerplate.ui.custom.SnackbarOptions
import net.breez.data.model.toSOR
import net.breez.composeboilerplate.ui.RegistrationCommand
import javax.inject.Inject

class PhoneInputReducer @Inject constructor() : Reducer<PhoneInputState, PhoneInputAction> {
    override fun reduce(
        currentState: PhoneInputState,
        action: PhoneInputAction
    ): ReducerResult<PhoneInputState> {
        return when (action) {
            is PhoneInputAction.ShowCountryOptions -> onUserWantChangedCountry(currentState)
            is PhoneInputAction.SelectedCountry -> onCountrySelected(action, currentState)
            is PhoneInputAction.PhoneNumberInserted -> onPhoneNumberChanged(action, currentState)
            is PhoneInputAction.PasswordInserted -> onPasswordChanged(action, currentState)
            is PhoneInputAction.SubmitPhoneAndPassword -> submitPhoneAndPassword(currentState)
            is PhoneInputAction.SignInConfirmed -> onSignInConfirmed(currentState, action)
            is PhoneInputAction.SignInFailed -> onSignInFailed(currentState, action)
            is PhoneInputAction.UserCloseBottomSheet -> onUserCloseBottomSheet(currentState)
        }
    }

    private fun onUserCloseBottomSheet(currentState: PhoneInputState): ReducerResult<PhoneInputState> {
        return ReducerResult(
            currentState.copy(showCountrySelectDialog = false)
        )
    }

    private fun submitPhoneAndPassword(
        currentState: PhoneInputState
    ): ReducerResult<PhoneInputState> {
        return ReducerResult(
            currentState.copy(
                isLoading = true
            ),
            command = RegistrationCommand.SignIn(
                currentState.phoneNumber,
                currentState.password
            )
        )
    }

    private fun onUserWantChangedCountry(
        currentState: PhoneInputState
    ): ReducerResult<PhoneInputState> {
        return ReducerResult(currentState.copy(showCountrySelectDialog = true))
    }

    private fun onSignInFailed(
        currentState: PhoneInputState,
        action: PhoneInputAction.SignInFailed
    ): ReducerResult<PhoneInputState> {
        val message = action.throwable.message ?: "Произошла ошибка"
        return ReducerResult(
            currentState.copy(
                isLoading = false,
                exception = action.throwable
            ),
            oneShotEvents = arrayOf(SnackbarOptions(message).toOneShotEvent())
        )
    }

    private fun onSignInConfirmed(
        currentState: PhoneInputState,
        action: PhoneInputAction.SignInConfirmed
    ): ReducerResult<PhoneInputState> {
        val message = "User ${action.profileModel.firstName} signed in"

        return ReducerResult(
            currentState.copy(
                isLoading = false,
                profileModel = action.profileModel
            ),
            oneShotEvents = arrayOf(
                SnackbarOptions(message).toOneShotEvent(),
                ToastEventData(message.toSOR()).toOneShotEvent()
            )
        )
    }

    private fun onCountrySelected(
        action: PhoneInputAction.SelectedCountry,
        currentState: PhoneInputState
    ): ReducerResult<PhoneInputState> {
        return ReducerResult(
            currentState.copy(
                country = action.phoneNumberMasks,
                showCountrySelectDialog = false
            )
        )
    }

    private fun onPhoneNumberChanged(
        action: PhoneInputAction.PhoneNumberInserted,
        currentState: PhoneInputState
    ): ReducerResult<PhoneInputState> {
        return ReducerResult(
            currentState.copy(
                phoneNumber = action.actualValue
            )
        )
    }

    private fun onPasswordChanged(
        action: PhoneInputAction.PasswordInserted,
        currentState: PhoneInputState
    ): ReducerResult<PhoneInputState> {
        return ReducerResult(
            currentState.copy(
                password = action.actualValue
            )
        )
    }
}