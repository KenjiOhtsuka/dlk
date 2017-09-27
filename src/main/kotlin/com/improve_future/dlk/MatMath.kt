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

    fun max(a: Double, v: Matrix): Matrix {
        val matrix = Matrix(v.rowSize, v.colSize)
        v.values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                matrix[rowIndex, colIndex] = Math.max(a, value)
            }
        }
        return matrix
    }

    fun sum(v: Matrix): Double {
        var result = 0.0
        v.values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                result += value
            }
        }
        return result
    }

    fun max(x: Matrix): Double {
        var maxValue: Double? = null
        x.values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                if (maxValue == null) maxValue = value
                else maxValue = Math.max(value, maxValue!!)
            }
        }
        return maxValue!!
    }
}