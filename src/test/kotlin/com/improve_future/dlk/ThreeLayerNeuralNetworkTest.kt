package com.improve_future.dlk

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ThreeNeuralNetworkTest {
    /**
     * 3 Layer Neural Network (3.4 in the book)
     */
    @Test
    fun testExample() {
        val delta = 0.00000001

        val x = Matrix(arrayOf(1.0, 0.5))
        val w1 = Matrix(arrayOf(
                arrayOf(0.1, 0.3, 0.5),
                arrayOf(0.2, 0.4, 0.6)
        ))
        val b1 = Matrix(arrayOf(0.1, 0.2, 0.3))

        val a1 = x * w1 + b1
        val z1 = ActivationFunction.sigmoid(a1)

        assertTrue(Math.abs(0.57444252 - z1[0, 0]) < delta)
        assertTrue(Math.abs(0.66818777 - z1[0, 1]) < delta)
        assertTrue(Math.abs(0.75026011 - z1[0, 2]) < delta)

        val w2 = Matrix(arrayOf(
                arrayOf(0.1, 0.4),
                arrayOf(0.2, 0.5),
                arrayOf(0.3, 0.6)
        ))
        val b2 = Matrix(arrayOf(0.1, 0.2))

        val a2 = z1 * w2 + b2
        val z2 = ActivationFunction.sigmoid(a2)

        val w3 = Matrix(arrayOf(
                arrayOf(0.1, 0.3),
                arrayOf(0.2, 0.4)
        ))
        val b3 = Matrix(arrayOf(0.1, 0.2))
        val a3 = z2 * w3 + b3

        val identifyFunction = fun (x: Matrix): Matrix { return x }

        val y = identifyFunction(a3)

        assertTrue(Math.abs(y[0, 0] - 0.31682708) < delta)
        assertTrue(Math.abs(y[0, 1] - 0.69627909) < delta)
    }
}