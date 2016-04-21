package _1_hello.kotlin

fun Array<*>.firstOrNull() = if (this.size >= 1) this[0] else null

fun main(args: Array<String>) {
    // Extension function + Elvis
    val name = args.firstOrNull() ?: "Kotlin"
    // String template
    println("Hello, $name, I am glad to see you")
}
