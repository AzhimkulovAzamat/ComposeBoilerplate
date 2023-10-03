package net.breez.domain

sealed class UIState<out T> {
    object Loading: UIState<Nothing>() {

        override fun getValue(): String? = null
    }

    class Error(val error: Throwable) : UIState<Nothing>() {
        override fun getValue(): String? = error.message
    }

    class Success<T>(val data: T) : UIState<T>() {
        override fun getValue(): String = data.toString()
    }

    abstract fun getValue(): String?
}
