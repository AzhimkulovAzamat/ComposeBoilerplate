package net.breez.composeboilerplate.mvi.redux

data class ReducerResult<S: State> internal constructor(
    val state: S,
    val oneShotEvents: List<OneShotEvent>,
    val command: Command
) {
    constructor(state: S, vararg oneShotEvents: OneShotEvent, command: Command = UndefinedCommand()): this(state, oneShotEvents.toList(), command)
}
