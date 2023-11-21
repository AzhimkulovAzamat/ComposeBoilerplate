package net.breez.composeboilerplate.mvi.time.travel.debugging

import net.breez.composeboilerplate.mvi.redux.State
import net.breez.domain.collection.queueOf

interface TimeTravelDebugging {

    fun debugSates(state: Collection<State>)

    fun next(): State?
}

class TimeTravelDebuggingImpl: TimeTravelDebugging {
    private val collection = queueOf<State>()

    override fun debugSates(state: Collection<State>) {
        collection.addAll(state)
    }

    override fun next(): State? {
        return collection.poll()
    }
}