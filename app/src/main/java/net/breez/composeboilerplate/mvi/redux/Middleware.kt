package net.breez.composeboilerplate.mvi.redux

import com.google.gson.Gson

interface Middleware<out E, in C> where E: Event, C: Command{

    suspend fun process(command: C): E
}

interface MiddlewareContainer {
    suspend fun process(command: Command): Event

    fun defaultEvent(): Event = EmptyEvent()
}

interface Command: LogEvent

class UndefinedCommand:Command

interface Event: LogEvent

class EmptyEvent: Event