package _3_polish.kotlin

import java.util.*

class ArithmeticStack {

    // Type inference
    private val stack = LinkedList<Double>()

    // Enums and lambdas
    enum class Operation(internal val function: (Double, Double) -> Double) {
        PLUS({ x, y -> x + y }),
        MINUS({ x, y -> y - x }),
        TIMES({ x, y -> x * y }),
        DIV({ x, y -> y / x })
    }

    // Expression function syntax
    fun push(x: Double) = stack.push(x)

    fun top() = stack.peek()

    // Lambda invocation
    fun execute(op: Operation) = stack.push(op.function(stack.pop(), stack.pop()))
}