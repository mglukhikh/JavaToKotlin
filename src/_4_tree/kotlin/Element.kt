package _4_tree.kotlin

// Algebraic type, generic, use-site variance (out)
sealed class Element<Key, Value>(val key: Key, val value: Value) {
    class Leaf<Key, Value>(key: Key, value: Value) : Element<Key, Value>(key, value)

    class Tree<Key, Value>(
            key: Key, value: Value,
            val left: Element<Key, Value>,
            val right: Element<Key, Value>? = null
    ) : Element<Key, Value>(key, value)
}

fun <K, V> Element<K, V>.search(key: K): V? =
        if (this.key == key) value
        // Exhaustive when
        else when (this) {
            is Element.Leaf -> null
            is Element.Tree -> this.left.search(key) ?: right?.search(key)
        }

fun <K : Comparable<K>, V> Element<K, V>.binSearch(key: K): V? =
        if (this.key == key) value
        else when (this) {
            is Element.Leaf -> null
            // operator overload (<)
            is Element.Tree -> if (key < this.key) left.binSearch(key) else right?.binSearch(key)
        }
