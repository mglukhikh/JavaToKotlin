package _2_exceptions.kotlin

interface Base
class Derived : Base {
    fun fromDerived() {}
}
fun caller(x: Base) {
    //(x as? Derived).fromDerived()  // Error
    (x as? Derived)?.fromDerived() // OK, safe call
    if (x is Derived) {
        x.fromDerived()            // OK, smart cast
    }
    (x as Derived).fromDerived()   // OK, CCE possible
}