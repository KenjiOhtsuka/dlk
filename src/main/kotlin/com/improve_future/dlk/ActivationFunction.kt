package com.improve_future.dlk

object ActivationFunction {
    fun sigmoid(v: Matrix): Matrix {
        return 1 / (1 + MatMath.exp(- v))
    }

    fun relu(x: Matrix): Matrix {
        return rectifiedLinearUnit(x)
    }

    fun rectifiedLinearUnit(x: Matrix): Matrix {
        return MatMath.max(0.0, x)
    }
}