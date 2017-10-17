package com.improve_future.dlk.layer

import com.improve_future.dlk.ActivationFunction
import com.improve_future.dlk.LossFunction
import com.improve_future.dlk.Matrix

class BatchSoftmaxWithLossLayer {
    var loss: Double = 0.0
    lateinit var y: Matrix
    /** teacher data */
    lateinit var t: Matrix

    fun forward(x: Matrix, t: Matrix): Double {
        this.t = t
        this.y = ActivationFunction.softmaxFunction(x)
        loss = LossFunction.crossEntropyError(y, t)
        return loss
    }

    fun backward(dout: Matrix): Matrix {
        return (y - t) / t.rowSize
    }
}