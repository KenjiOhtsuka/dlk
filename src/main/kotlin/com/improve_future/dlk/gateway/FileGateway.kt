package com.improve_future.dlk.gateway

import java.io.File

object FileGateway {
    fun fileExist(path: String): Boolean {
        val f = File(path)
        return f.exists()
    }
}