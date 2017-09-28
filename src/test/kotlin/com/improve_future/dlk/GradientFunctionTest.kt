package com.improve_future.dlk

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GradientFunctionTest {
    val delta = 0.00000001

    @Test
    fun testNumericalDiff() {

        val f = fun (x: Double): Double {
            return 0.01 * Math.pow(x, 2.0) + 0.1 * x
        }

        var diff: Double
        diff = GradientFunction.numericalDiff(f, 5.0)
        assertTrue(Math.abs(diff - 0.1999999999990898) < delta)
        diff = GradientFunction.numericalDiff(f, 10.0)
        assertTrue(Math.abs(diff - 0.2999999999986347) < delta)
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
        assertTrue(Math.abs(6.0 - grad[0, 0]) < delta)
        assertTrue(Math.abs(8.0 - grad[0, 1]) < delta)

        x = Matrix(arrayOf(0, 2))
        grad = GradientFunction.numericalGradient(f, x)
        assertTrue(Math.abs(0.0 - grad[0, 0]) < delta)
        assertTrue(Math.abs(4.0 - grad[0, 1]) < delta)

        x = Matrix(arrayOf(3, 0))
        grad = GradientFunction.numericalGradient(f, x)
        assertTrue(Math.abs(6.0 - grad[0, 0]) < delta)
        assertTrue(Math.abs(0.0 - grad[0, 1]) < delta)
    }

    @Test
    fun testGradientDescent() {
        val f = fun (x: Matrix): Double {
            return MatMath.sum(
                    x.apply {
                        Math.pow(it, 2.0)
                    }
            )
        }
        val x = Matrix(arrayOf(-3.0, 4.0))
        val r = GradientFunction.gradientDescent(
                f, x, 0.1)

        assertTrue(Math.abs(-6.11110793e-10 - r[0, 0]) < Math.abs(r[0, 0]) / 10000000)
        assertTrue(Math.abs(8.14814391e-10 - r[0, 1]) < Math.abs(r[0, 0]) / 10000000)
    }
}