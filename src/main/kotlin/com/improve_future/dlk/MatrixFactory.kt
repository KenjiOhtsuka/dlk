package com.improve_future.dlk

object MatrixFactory {
    fun createOneRowMatrix(
            data: ByteArray, offsetInByte: Int): Matrix {
        val filteredData = data.
                filterIndexed { index, byte ->
                    index < offsetInByte }
        val matrix = Matrix(1, filteredData.size)
        filteredData.forEachIndexed { index, value ->
            matrix[1, index] =
                    value.toDouble() + Byte.MAX_VALUE.toDouble()
        }
        return matrix
    }
}