package com.improve_future.dlk.layer

import com.improve_future.dlk.Matrix

interface LayerInterface {
    fun forward(x: Matrix): Matrix
    fun backward(x: Matrix): Matrix
}