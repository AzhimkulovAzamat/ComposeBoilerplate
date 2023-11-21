package net.breez.composeboilerplate.mvi.splash

import net.breez.composeboilerplate.mvi.redux.Reducer
import net.breez.composeboilerplate.mvi.redux.ReducerResult
import net.breez.composeboilerplate.ui.custom.SnackbarOptions

class SplashReducer : Reducer<SplashState, SplashAction> {
    override fun reduce(
        currentState: SplashState,
        action: SplashAction
    ): ReducerResult<SplashState> {
        return when (action) {
            is SplashAction.FetchUserFailed -> {
                ReducerResult(
                    currentState,
                    oneShotEvents = arrayOf(
                        SnackbarOptions(
                            action.throwable.message ?: "Произошла ошибка"
                        ).toOneShotEvent()
                    )
                )
            }

            is SplashAction.FetchUserSucceeded -> {
                ReducerResult(
                    currentState
                )
            }
        }
    }
}