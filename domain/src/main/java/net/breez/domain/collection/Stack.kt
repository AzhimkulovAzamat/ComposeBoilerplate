package net.breez.domain.collection

class Queue<E> {

    private val collection = mutableListOf<E>()

    fun addAll(collection: Collection<E>) {
        this.collection.addAll(collection)
    }

    fun push(element: E) {
        this.collection.add(element)
    }

    fun poll(): E? {
        return this.collection.removeFirstOrNull()
    }

    fun peek(): E? {
        return this.collection.firstOrNull()
    }
}

fun <E> queueOf(vararg element: E): Queue<E> {
    return Queue<E>().apply { addAll(element.toList()) }
}