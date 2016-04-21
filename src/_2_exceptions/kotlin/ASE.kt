package _2_exceptions.kotlin

// TODO: comment both foo in this file
fun foo(arr: Array<String>) {
    // Error! Arrays are invariant in Kotlin
    val anyArr: Array<Any> = arr
    anyArr[0] = 42 // ASE in Java

    val anyOutArr: Array<out Any> = arr
    // Error! Out projection does not allow this
    anyOutArr[0] = 42
}

fun foo(list: List<String>) {
    // OK! Lists are covariant in Kotlin
    val anyList: List<Any> = list
    anyList[0] = 42 // Error! List is read-only
}
