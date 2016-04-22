package _5_polish.kotlin

import org.junit.Test

import org.junit.Assert.*

class CalculatorTest {

    @Test
    fun testCalc() {
        assertEquals(7.0, polishCalculate("1 2 3 * +"), 1e-6)
        assertEquals(10.0, polishCalculate("6 -4 -"), 1e-6)
        assertEquals(3.0, polishCalculate("10 1 2 3 * + -"), 1e-6)
    }

    @Test
    fun testCalcFunctional() {
        assertEquals(7.0, polishCalculateFunctional("1 2 3 * +"), 1e-6)
        assertEquals(10.0, polishCalculateFunctional("6 -4 -"), 1e-6)
        assertEquals(3.0, polishCalculateFunctional("10 1 2 3 * + -"), 1e-6)
    }
}