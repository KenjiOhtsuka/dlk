package com.improve_future.dlk

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MatrixTest {
    @Test
    fun testInit() {
        var matrix = Matrix(2, 2)
        assertEquals(0.0, matrix[0, 0])
        assertEquals(0.0, matrix[0, 1])
        assertEquals(0.0, matrix[1, 0])
        assertEquals(0.0, matrix[1, 1])

        matrix = Matrix(
                arrayOf(
                        doubleArrayOf(0.1, 0.2, 0.3),
                        doubleArrayOf(0.4, 0.5, 0.6)
                )
        )
        assertEquals(0.1, matrix[0, 0])
        assertEquals(0.2, matrix[0, 1])
        assertEquals(0.3, matrix[0, 2])
        assertEquals(0.4, matrix[1, 0])
        assertEquals(0.5, matrix[1, 1])
        assertEquals(0.6, matrix[1, 2])
    }

    @Test
    fun testEquals() {
        val a = Matrix(
                arrayOf(
                        doubleArrayOf(1.0, 2.0, 3.0),
                        doubleArrayOf(4.0, 5.0, 6.0),
                        doubleArrayOf(7.0, 8.0, 9.0),
                        doubleArrayOf(10.0, 11.0, 12.0)
                )
        )
        val b = Matrix(
                arrayOf(
                        doubleArrayOf(1.0, 2.0, 3.0),
                        doubleArrayOf(4.0, 5.0, 6.0),
                        doubleArrayOf(7.0, 8.0, 9.0),
                        doubleArrayOf(10.0, 11.0, 12.0)
                )
        )
        val c = Matrix(
                arrayOf(
                        doubleArrayOf(-1.0, 2.0, 3.0),
                        doubleArrayOf(4.0, 5.0, 6.0),
                        doubleArrayOf(7.0, 8.0, 9.0),
                        doubleArrayOf(10.0, 11.0, 12.0)
                )
        )
        assertTrue(a == b)
        assertFalse(a == c)
    }

    @Test
    fun testTimes() {
        val a = Matrix(
                arrayOf(
                    doubleArrayOf(1.0, 2.0, 3.0),
                    doubleArrayOf(4.0, 5.0, 6.0),
                    doubleArrayOf(7.0, 8.0, 9.0),
                    doubleArrayOf(10.0, 11.0, 12.0)
                )
        )
        val b = Matrix(
                arrayOf(
                        doubleArrayOf(-1.0, 2.0),
                        doubleArrayOf(3.0, -4.0),
                        doubleArrayOf(-5.0, 6.0)
                )
        )
        val c = a * b
        assertEquals((-1 + 6 - 15).toDouble(), c[0, 0])
        assertEquals((-4 + 15 - 30).toDouble(), c[1, 0])
        assertEquals((-7 + 24 - 45).toDouble(), c[2, 0])
        assertEquals((-10 + 33 - 60).toDouble(), c[3, 0])
        assertEquals((2 - 8 + 18).toDouble(), c[0, 1])
        assertEquals((8 - 20 + 36).toDouble(), c[1, 1])
        assertEquals((14 - 32 + 54).toDouble(), c[2, 1])
        assertEquals((20 - 44 + 72).toDouble(), c[3, 1])
    }

    @Test
    fun testNumberTimes() {
        val a = Matrix(
                arrayOf(
                        doubleArrayOf(1.0, 2.0, 3.0),
                        doubleArrayOf(4.0, 5.0, 6.0)
                )
        )
        val b = a * 2
        assertEquals(2.0, b[0, 0])
        assertEquals(4.0, b[0, 1])
        assertEquals(6.0, b[0, 2])
        assertEquals(8.0, b[1, 0])
        assertEquals(10.0, b[1, 1])
        assertEquals(12.0, b[1, 2])

        val c = 2 * a
        assertTrue(b == c)
    }

    @Test
    fun testToString() {
        val a = Matrix(
                arrayOf(
                        doubleArrayOf(1.0, 2.0, 3.0),
                        doubleArrayOf(4.0, 5.0, 6.0)
                )
        )
        assertEquals(
            a.toString(),
                "1.0000 2.0000 3.0000\n" +
                        "4.0000 5.0000 6.0000")
    }


    class RandomTest {
        @Test
        fun testRandom() {
            var a: Matrix

            a = Matrix.Random(1)
            assertEquals(1, a.rowSize)
            assertEquals(1, a.colSize)
            assertTrue(a[0, 0] >= 0.0)
            assertTrue(a[0, 0] <= 1.0)

            a = Matrix.Random(2, 3)
            assertEquals(2, a.rowSize)
            assertEquals(3, a.colSize)
            a.forEach {
                assertTrue(a[it.first, it.second] >= 0.0)
                assertTrue(a[it.first, it.second] <= 1.0)
            }
        }
    }

    class ZeroTest {
        @Test
        fun testZero() {
            var a: Matrix

            a = Matrix.Zero(1)
            assertEquals(1, a.rowSize)
            assertEquals(1, a.colSize)
            assertEquals(0.0, a[0, 0])
            assertEquals(0.0, a[0, 0])

            a = Matrix.Zero(2, 3)
            assertEquals(2, a.rowSize)
            assertEquals(3, a.colSize)
            a.forEach {
                assertEquals(0.0, a[it.first, it.second])
            }
        }
    }
}