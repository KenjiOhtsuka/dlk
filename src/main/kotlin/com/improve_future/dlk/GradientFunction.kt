package com.improve_future.dlk

object GradientFunction {
    val h = 1e-4

    fun numericalDiff(f: (Matrix) -> Matrix, x: Matrix): Matrix {
        return (f(x + h) - f(x - h)) / (2 * h)
    }

    fun numericalDiff(f: (Double) -> Double, x: Double): Double {
        return (f(x + h) - f(x - h)) / (2 * h)
    }

    fun numericalDiff(f: (Double) -> Double, x: Int): Double {
        return numericalDiff(f, x.toDouble())
    }

    fun numericalGradient(f: (Double) -> Double, x: Matrix): Matrix {
        return x.apply { numericalDiff(f, it) }
    }
}