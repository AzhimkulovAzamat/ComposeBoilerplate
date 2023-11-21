package net.breez.composeboilerplate.mvi.redux

interface PostProcessor<E : Event, A : Action> {

    fun process(event: E): A
}

interface PostProcessorContainer {

    suspend fun process(event: Event): Action?

    fun defaultAction(): Action? = null
}