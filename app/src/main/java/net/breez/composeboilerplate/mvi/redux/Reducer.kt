package net.breez.composeboilerplate.mvi.redux

interface Reducer<S: State, A: Action> {
    fun reduce(currentState: S, action: A): ReducerResult<S>
}