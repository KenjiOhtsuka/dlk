package com.improve_future.dlk

class Matrix(val rowSize: Int, val colSize: Int) {
    val values: Array<DoubleArray>

    constructor(values: Array<DoubleArray>): this(values.size, values[0].size) {
        values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                this[rowIndex, colIndex] = value
            }
        }
    }

    constructor(values: Array<Array<Number>>): this(values.size, values[0].size) {
        values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                this[rowIndex, colIndex] = value.toDouble()
            }
        }
    }

    constructor(values: Array<Array<String>>): this(values.size, values[0].size) {
        values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                this[rowIndex, colIndex] = value.toDouble()
            }
        }
    }

    init {
        values = Array(rowSize) {
            DoubleArray(colSize)
        }
    }

    fun toArray(): DoubleArray {
        val oneDimensionalArray = DoubleArray(rowSize * colSize)
        var i = 0
        for (doubles in values) {
            doubles.forEach {
                oneDimensionalArray[i] = it
            }
        }
        return oneDimensionalArray
    }

    operator fun get(row: Int, col: Int): Double {
        return values[row][col]
    }

    operator fun set(rowIndex: Int, colIndex: Int, value: Double): Matrix {
        values[rowIndex][colIndex] = value
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other::class != Matrix::class) return false

        val otherMatrix = other as Matrix

        this.values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                if (value != otherMatrix[rowIndex, colIndex]) return false
            }
        }
        return true
    }

    override fun toString(): String {
        return toString(4)
    }

    fun toString(decimalPoint: Int): String {
        var str = ""
        this.values.forEachIndexed { rowIndex, row ->
            if (rowIndex != 0) str += "\n"
            row.forEachIndexed { colIndex, value ->
                if (colIndex != 0) str += " "
                str += value.toString()
            }
        }
        return str
    }

    operator infix fun times(other: Matrix): Matrix {
        val matrix = Matrix(this.rowSize, other.colSize)
        this.values.forEachIndexed { rowIndex, row ->
            for (colIndex in 0..(other.colSize - 1)) {
                row.forEachIndexed { tempIndex, value ->
                    matrix[rowIndex, colIndex] += value * other[tempIndex, colIndex]
                }
            }
        }
        return matrix
    }

    operator fun times(other: Number): Matrix {
        return times(other.toDouble())
    }

    operator fun times(other: Int): Matrix {
        return times(other.toDouble())
    }

    operator fun times(other: Double): Matrix {
        val matrix = Matrix(this.rowSize, this.colSize)
        this.values.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                matrix[rowIndex, colIndex] = value * other
            }
        }
        return matrix
    }
}

operator infix fun Number.times(other: Matrix): Matrix {
    return other.times(this)
}