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

    fun numericalGradient(f: (Matrix) -> Double, x: Matrix): Matrix {
        val grad = Matrix(x.colSize, x.rowSize)
        var temp: Double
        var left: Double
        var right: Double

        x.forEach {
            temp = x[it.first, it.second]

            x[it.first, it.second] = temp - h
            left = f(x)

            x[it.first, it.second] = temp + h
            right = f(x)

            x[it.first, it.second] = temp

            grad[it.first, it.second] = (right - left) / (2 * h)
        }

        return grad
    }
}