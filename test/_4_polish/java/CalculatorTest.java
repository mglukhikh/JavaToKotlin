package _4_polish.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testCalc() {
        assertEquals(7.0, Calculator.calc("1 2 3 * +"), 1e-6);
        assertEquals(10.0, Calculator.calc("6 -4 -"), 1e-6);
        assertEquals(3.0, Calculator.calc("10 1 2 3 * + -"), 1e-6);
    }

    @Test
    public void testCalcFunctional() {
        assertEquals(7.0, Calculator.calcFunctional("1 2 3 * +"), 1e-6);
        assertEquals(10.0, Calculator.calcFunctional("6 -4 -"), 1e-6);
        assertEquals(3.0, Calculator.calcFunctional("10 1 2 3 * + -"), 1e-6);
    }
}