package _5_polish.kotlin

// Singleton
object Calculator {
    private val operationMap = mapOf<String, (Double, Double) -> Double>(
            "+" to { x, y -> x + y },
            "-" to { x, y -> y - x },
            "*" to { x, y -> x * y },
            "/" to { x, y -> x / y }
    )

    fun calc(expr: String): Double {
        val stack = ArithmeticStack()
        for (arg in expr.split(" ")) {
            val op = operationMap[arg]
            if (op != null) {
                stack.execute(op)
            }
            else {
                stack.push(arg.toDouble())
            }
        }
        return stack.top()
    }

    fun calcFunctional(expr: String): Double {
        val stack = ArithmeticStack()
        // Extension: for-each
        expr.split(" ").forEach {
            // it = single argument
            // let: receiver --> argument                     // elvis, toDouble()
            operationMap[it]?.let { op -> stack.execute(op) } ?: stack.push( it.toDouble() )
        }
        return stack.top()
    }
}