package net.breez.domain.interactor

sealed class FlowResult<out T> {

    class Success<T>(val element: T) : FlowResult<T>()
    class HttpException(val code: Int, val throwable: Throwable) : FlowResult<Nothing>()
    class OtherException(val throwable: Throwable) : FlowResult<Nothing>()
}