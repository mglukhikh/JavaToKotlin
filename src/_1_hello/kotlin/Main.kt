package _1_hello.kotlin

fun main(args: Array<String>) {
    // Extension function + Elvis
    val name = args.firstOrNull() ?: "Kotlin"
    // String template
    println("Hello, $name")
}
