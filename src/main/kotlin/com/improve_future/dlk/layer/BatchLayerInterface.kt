package com.improve_future.dlk.layer

import com.improve_future.dlk.Matrix

interface BatchLayerInterface {
    fun forward(x: Matrix): Matrix
    fun backward(dout: Matrix): Matrix
}