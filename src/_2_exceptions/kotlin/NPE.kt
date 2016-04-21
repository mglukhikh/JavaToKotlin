package _2_exceptions.kotlin

class Type(val x: Int) {
    fun foo() = x
}

fun doIfNull() = 0

fun caller(x: Type? /* ? means "can be null" */) {
    // TODO: comment me
    x.foo()   // Error: x can be null
    x?.foo()  // OK, safe call
    x?.foo() ?: doIfNull() // OK: safe call + Elvis
    if (x != null) {
        x.foo() // OK, smart cast
        println(x)
    }
    x!!.foo() // OK, but KNPE is possible
}
