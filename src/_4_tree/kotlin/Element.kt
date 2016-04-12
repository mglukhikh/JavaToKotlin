package _4_tree.kotlin

// Algebraic type, generic, use-site variance (out)
sealed class Element<Key : Comparable<Key>, out Value>(val key: Key, val value: Value) {
    class Leaf<Key : Comparable<Key>, Value>(key: Key, value: Value) : Element<Key, Value>(key, value)

    class Tree<Key : Comparable<Key>, Value>(key: Key, value: Value,
                           val left: Element<Key, Value>?,
                           val right: Element<Key, Value>? = null) :
            Element<Key, Value>(key, value)

    fun search(key: Key): Value? =
            if (this.key == key) value
            // Exhaustive when
            else when (this) {
                is Leaf -> null
                is Tree -> this.left?.search(key) ?: right?.search(key)
            }

    fun binarySearch(key: Key): Value? =
            if (this.key == key) value
            else when (this) {
                is Leaf -> null
                // operator overload (<)
                is Tree -> if (key < this.key) left?.search(key) else right?.search(key)
            }
}