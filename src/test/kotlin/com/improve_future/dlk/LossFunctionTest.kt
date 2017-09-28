package com.improve_future.dlk

import org.junit.Test
import kotlin.test.assertTrue

class LossFunctionTest {
    val delta = 0.00000001

    @Test
    fun testMeanSquaredError() {
        val t = Matrix(arrayOf(0, 0, 1, 0, 0, 0, 0, 0, 0, 0))
        var loss: Double

        val y1 = Matrix(arrayOf(0.1, 0.05, 0.6, 0.0, 0.05, 0.1, 0.0, 0.1, 0.0, 0.0))
        loss = LossFunction.meanSquaredError(y1, t)
        assertTrue(Math.abs(loss - 0.0975) < delta)

        val y2 = Matrix(arrayOf(0.1, 0.05, 0.1, 0.0, 0.05, 0.1, 0.0, 0.6, 0.0, 0.0))
        loss = LossFunction.meanSquaredError(y2, t)
        assertTrue(Math.abs(loss - 0.5975) < delta)
    }

    @Test
    fun testCrossEntropyError() {
        val t = Matrix(arrayOf(0, 0, 1, 0, 0, 0, 0, 0, 0, 0))
        var loss: Double

        val y1 = Matrix(arrayOf(0.1, 0.05, 0.6, 0.0, 0.05, 0.1, 0.0, 0.1, 0.0, 0.0))
        loss = LossFunction.crossEntropyError(y1, t)
        assertTrue(Math.abs(loss - 0.51082545709933802) < delta)

        val y2 = Matrix(arrayOf(0.1, 0.05, 0.1, 0.0, 0.05, 0.1, 0.0, 0.6, 0.0, 0.0))
        loss = LossFunction.crossEntropyError(y2, t)
        assertTrue(Math.abs(loss - 2.3025840929945458) < delta)
    }
}