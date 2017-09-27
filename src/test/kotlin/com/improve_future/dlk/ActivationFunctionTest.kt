package com.improve_future.dlk

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ActivationFunctionTest {
    val delta = 0.00000001

    @Test
    fun testStepFunction() {
        val a = Matrix(arrayOf(arrayOf(0.0, 0.1)))
        val b = ActivationFunction.stepFunction(a)
        assertEquals(0.0, b[0, 0])
        assertEquals(1.0, b[0, 1])
    }

    @Test
    fun testRelu() {
        val a = Matrix(arrayOf(arrayOf(0.0, 0.1, -0.1)))
        val b = ActivationFunction.stepFunction(a)
        assertEquals(0.0, b[0, 0])
        assertEquals(1.0, b[0, 1])
        assertEquals(0.0, b[0, 2])
    }

    @Test
    fun testSigmoidFunction() {
        val a = Matrix(arrayOf(arrayOf(-1.0, 0.0, 1.0)))
        val b = ActivationFunction.sigmoid(a)
        assertEquals(1.0 / (1 + Math.exp(1.0)), b[0, 0])
        assertEquals(1.0 / (1 + Math.exp(0.0)), b[0, 1])
        assertEquals(1.0 / (1 + Math.exp(-1.0)), b[0, 2])
    }

    @Test
    fun testSoftmaxFunction() {
        val a = Matrix(arrayOf(0.3, 2.9, 4.0))
        val b = ActivationFunction.softmaxFunction(a)
        assertTrue(Math.abs(b[0, 0] - 0.01821127) < delta)
        assertTrue(Math.abs(b[0, 1] - 0.24519181) < delta)
        assertTrue(Math.abs(b[0, 2] - 0.73659691) < delta)
    }
}