package net.breez.composeboilerplate.mvi.redux

interface Bootstrapper<A: Action> {
    suspend fun viewDidLoad(newAction: suspend (A) -> Unit)

    suspend fun viewReload(newAction: suspend (A) -> Unit)
}