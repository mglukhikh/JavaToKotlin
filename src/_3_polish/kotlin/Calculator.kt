package _3_polish.kotlin

import _3_polish.kotlin.ArithmeticStack.Operation.*

// Singleton
object Calculator {
    private val operationMap = mapOf(
            "+" to PLUS,
            "-" to MINUS,
            "*" to TIMES,
            "/" to DIV
    )

    fun calc(expr: String): Double {
        val stack = ArithmeticStack()
        // Extension: for-each
        expr.split(" ").forEach {
            // it = single argument
            // let: receiver --> argument
            operationMap[it]?.let { op -> stack.execute(op) }
            // elvis, toDouble()
            ?: stack.push( it.toDouble() )
        }
        return stack.top()
    }
}