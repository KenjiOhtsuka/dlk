package com.improve_future.dlk

object ActivationFunction {
    fun sigmoid(v: Matrix): Matrix {
        return 1 / (1 + MatMath.exp(- v))
    }
}