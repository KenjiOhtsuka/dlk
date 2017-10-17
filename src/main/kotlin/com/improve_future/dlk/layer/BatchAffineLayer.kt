package com.improve_future.dlk.layer

import com.improve_future.dlk.Matrix

class BatchAffineLayer(
        var w: Matrix, var b: Matrix): BatchLayerInterface {
    lateinit var x: Matrix
    lateinit var dw: Matrix
    lateinit var db: Matrix

    override fun forward(x: Matrix): Matrix {
        this.x = x
        return x * w + b
    }

    override fun backward(dout: Matrix): Matrix {
        dw = x.t() * dout
        db = (Matrix(1, dout.rowSize) + 1.0) * dout
        return dout * w.t()
    }
}