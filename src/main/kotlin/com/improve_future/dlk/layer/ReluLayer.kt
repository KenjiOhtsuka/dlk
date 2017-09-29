package com.improve_future.dlk.layer

import com.improve_future.dlk.Matrix

class ReluLayer: LayerInterface {
    lateinit var mask: Matrix

    override fun forward(x: Matrix): Matrix {
        mask = x.apply { if (it <= 0) 1.0 else 0.0 }
        return x.apply { if (it <= 0) 0.0 else it }
    }

    override fun backward(dOut: Matrix): Matrix {
        //val dx = Matrix(dOut.rowSize, dOut.colSize)
        dOut.values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                dOut[rowIndex, colIndex] =
                        if (mask[rowIndex, colIndex] == 1.0) 0.0
                        else value
            }
        }
        return dOut
    }
}