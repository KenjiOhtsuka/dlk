package com.improve_future.dlk

import com.improve_future.dlk.layer.BatchAffineLayer

class TwoLayerNet(
        inputSize: Int,
        hiddenSize: Int,
        outputSize: Int,
        weightInitStd: Double = 0.01
) {
    val params = mapOf(
            "w1" to
                    weight*
    )
    val layers = mapOf {
        "Affine1" to BatchAffineLayer
    }
    init {

    }

    fun predict(x: Matrix) {
        return x
    }

    fun loss(x: Matrix, t: Matrix) {
        val y = predict(x)
        return lastLayer.forward(y, t)
    }

    fun accuracy(x: Matrix, t: Matrix) {
        val y = predict(x)
        y

        return MatMath.sum()
    }
}