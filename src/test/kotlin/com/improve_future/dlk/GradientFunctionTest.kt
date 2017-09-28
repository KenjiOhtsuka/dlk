package com.improve_future.dlk

import org.junit.Test
import kotlin.test.assertEquals
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

    @Test
    fun testNumericalGradient() {
        var grad: Matrix
        var x: Matrix
        val f = fun (x: Matrix): Double {
            return MatMath.sum(
                x.apply {
                    Math.pow(it, 2.0)
                }
            )
        }

        x = Matrix(arrayOf(3, 4))
        grad = GradientFunction.numericalGradient(f, x)
        assertEquals(6.0, x[0, 0])
        assertEquals(8.0, x[0, 1])

        x = Matrix(arrayOf(0, 2))
        grad = GradientFunction.numericalGradient(f, x)
        assertEquals(0.0, x[0, 0])
        assertEquals(4.0, x[0, 1])

        x = Matrix(arrayOf(3, 0))
        grad = GradientFunction.numericalGradient(f, x)
        assertEquals(6.0, x[0, 0])
        assertEquals(0.0, x[0, 1])
    }
}