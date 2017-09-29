package com.improve_future.dlk.layer

import com.improve_future.dlk.ActivationFunction
import com.improve_future.dlk.Matrix

class SigmoidLayer: LayerInterface {
    lateinit var out: Matrix

    override fun forward(x: Matrix): Matrix {
        out = ActivationFunction.sigmoid(x)
        return out
    }

    override fun backward(dOut: Matrix): Matrix {
        val dx = Matrix(dOut.rowSize, dOut.colSize)
        dx.values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                val outValue = out[rowIndex, colIndex]
                dx[rowIndex, colIndex] =
                        dOut[rowIndex, colIndex] * (1.0 - outValue) * outValue
            }
        }
        return dx
    }
}