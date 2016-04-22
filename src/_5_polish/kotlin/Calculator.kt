package _5_polish.kotlin

import java.util.*

// Singleton
object Calculator {
    private val operationMap = mapOf<String, (Double, Double) -> Double>(
            "+" to { x, y -> x + y },
            "-" to { x, y -> y - x },
            "*" to { x, y -> x * y },
            "/" to { x, y -> x / y }
    )

    fun Stack<Double>.execute(op: (Double, Double) -> Double) = push(op(pop(), pop()))

    fun calc(expr: String): Double {
        val stack = Stack<Double>()
        for (arg in expr.split(" ")) {
            val op = operationMap[arg]
            if (op != null) {
                stack.execute(op)
            }
            else {
                stack.push(arg.toDouble())
            }
        }
        return stack.pop()
    }

    fun calcFunctional(expr: String): Double {
        val stack = Stack<Double>()
        // Extension: for-each
        expr.split(" ").forEach {
            // it = single argument
            // let: receiver --> argument                     // elvis, toDouble()
            operationMap[it]?.let { op -> stack.execute(op) } ?: stack.push( it.toDouble() )
        }
        return stack.pop()
    }
}