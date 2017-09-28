package com.improve_future.dlk

object LossFunction {
    fun meanSquaredError(a: Matrix, b: Matrix): Double {
        return MatMath.sum((a - b).apply { Math.pow(it, 2.0) / 2 })
    }
}