package com.improve_future.dlk

import java.lang.Math

object MatMath {
    fun exp(v: Matrix): Matrix {
        val matrix = Matrix(v.rowSize, v.colSize)
        v.values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                matrix[rowIndex, colIndex] = Math.exp(value)
            }
        }
        return matrix
    }

    fun log(v: Matrix): Matrix {
        val matrix = Matrix(v.rowSize, v.colSize)
        v.values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                matrix[rowIndex, colIndex] = Math.log(value)
            }
        }
        return matrix
    }
}