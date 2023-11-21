package net.breez.composeboilerplate.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


fun <T> MutableStateFlow<T>.mutate(copy:(T) -> T) {
    value = copy(value)
}