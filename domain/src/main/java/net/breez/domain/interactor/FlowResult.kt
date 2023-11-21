package net.breez.domain.interactor

sealed class FlowResult<out T> {

    class Success<T>(val element: T) : FlowResult<T>()
    class Exception(val throwable: Throwable) : FlowResult<Nothing>()
}