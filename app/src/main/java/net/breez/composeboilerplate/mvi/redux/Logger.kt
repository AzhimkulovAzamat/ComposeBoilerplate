package net.breez.composeboilerplate.mvi.redux

import com.google.gson.Gson

interface Logger {

    fun log(message: String)
    fun log(state: State)
    fun log(oneShotEvent: OneShotEvent)
    fun log(command: Command)
    fun log(action: Action)
    fun log(event: Event)
}

interface LogEvent {
    fun toJson(): String = Gson().toJson(this)
}