package com.improve_future.dlk

object LossFunction {
    fun meanSquaredError(y: Matrix, t: Matrix): Double {
        return MatMath.sum((y - t).apply { Math.pow(it, 2.0) / 2 })
    }

    fun crossEntropyError(y: Matrix, t: Matrix): Double {
        val delta: Double = 1E-7
        return - MatMath.sum(t * MatMath.log(y + delta).t())
    }
}