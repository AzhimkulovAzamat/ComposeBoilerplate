package net.breez.domain.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import net.breez.domain.UIState


abstract class FlowUseCase<T, Params> {

    fun execute(params: Params? = null): Flow<UIState<T>> {
        return doOnBackground(params).catch { emit(FlowResult.OtherException(it)) }.map {
            when (it) {
                is FlowResult.Success -> {
                    UIState.Success(it.element)
                }

                is FlowResult.HttpException -> {
                    UIState.Error(it.throwable)
                }

                is FlowResult.OtherException -> {
                    UIState.Error(it.throwable)
                }
            }
        }
    }

    protected abstract fun doOnBackground(params: Params?): Flow<FlowResult<T>>
}