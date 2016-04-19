package _4_polish.kotlin

import org.junit.Test

import org.junit.Assert.*

class CalculatorTest {

    @Test
    fun testCalc() {
        assertEquals(7.0, Calculator.calc("1 2 3 * +"), 1e-6)
        assertEquals(10.0, Calculator.calc("6 -4 -"), 1e-6)
        assertEquals(3.0, Calculator.calc("10 1 2 3 * + -"), 1e-6)
    }

    @Test
    fun testCalcFunctional() {
        assertEquals(7.0, Calculator.calcFunctional("1 2 3 * +"), 1e-6)
        assertEquals(10.0, Calculator.calcFunctional("6 -4 -"), 1e-6)
        assertEquals(3.0, Calculator.calcFunctional("10 1 2 3 * + -"), 1e-6)
    }
}