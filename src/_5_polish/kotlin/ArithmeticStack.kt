package _5_polish.kotlin

import java.util.*

class ArithmeticStack {

    // Type inference
    private val stack = LinkedList<Double>()

    // Expression function syntax
    fun push(x: Double) = stack.push(x)

    fun top() = stack.peek()

    // Lambda invocation
    fun execute(op: (Double, Double) -> Double) = stack.push(op(stack.pop(), stack.pop()))
}