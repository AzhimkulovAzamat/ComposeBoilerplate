package net.breez.domain.interactor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import net.breez.domain.UIState


abstract class UseCase<T, Params> {

    fun execute(params: Params? = null): Flow<UIState<T>> {
        return doOnBackground(params)
            .catch { emit(FlowResult.Exception(it)) }.map {
                when (it) {
                    is FlowResult.Success -> {
                        UIState.Success(it.element)
                    }

                    is FlowResult.Exception -> {
                        UIState.Error(it.throwable)
                    }
                }
            }.onStart { emit(UIState.Loading) }
    }

    protected abstract fun doOnBackground(params: Params?): Flow<FlowResult<T>>
}

abstract class FlowUseCase<T, Params> {

    operator fun invoke(
        scope: CoroutineScope,
        flow: MutableStateFlow<UIState<T>>,
        params: Params? = null
    ) {
        execute(scope, flow, params)
    }

    fun execute(scope: CoroutineScope, flow: MutableStateFlow<UIState<T>>, params: Params? = null) {
        scope.launch(Dispatchers.IO) {
            doOnBackground(params).catch { emit(FlowResult.Exception(it)) }
                .map {
                    when (it) {
                        is FlowResult.Success -> {
                            UIState.Success(it.element)
                        }

                        is FlowResult.Exception -> {
                            UIState.Error(it.throwable)
                        }
                    }
                }.onStart {
                    emit(UIState.Loading)
                }.collect {
                    flow.value = it
                }
        }
    }

    protected abstract fun doOnBackground(params: Params?): Flow<FlowResult<T>>
}