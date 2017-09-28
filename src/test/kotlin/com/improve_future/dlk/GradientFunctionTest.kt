package com.improve_future.dlk

import org.junit.Test
import kotlin.test.assertTrue

class GradientFunctionTest {
    @Test
    fun testNumericalDiff() {
        val delta = 0.00000001

        val f = fun (x: Double): Double {
            return Math.pow(0.01 * x, 2.0) + 0.1 * x
        }

        var diff: Double
        diff = GradientFunction.numericalDiff(f, 5.0)
        assertTrue(Math.abs(diff - 0.1999999999990898) > delta)
        diff = GradientFunction.numericalDiff(f, 10.0)
        assertTrue(Math.abs(diff - 0.2999999999986347) > delta)
    }
}