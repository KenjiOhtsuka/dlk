package com.improve_future.dlk.tool

import com.improve_future.dlk.Matrix
import com.improve_future.dlk.MatrixFactory
import com.improve_future.dlk.gateway.FileGateway
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream
import java.io.*
import java.net.URL
import java.util.zip.GZIPInputStream

object MnistTool {
    val urlBase = "http://yann.lecun.com/exdb/mnist/"

    val fileMap: Map<String, String> = mapOf(
            "train_image" to "train-images-idx3-ubyte.gz",
            "train_label" to "train-labels-idx1-ubyte.gz",
            "test_image" to "t10k-images-idx3-ubyte.gz",
            "test_label" to "t10k-labels-idx1-ubyte.gz"
    )

    val dataSetDir = ""//os.path.dirname(os.path.abspath(__file__))


    val trainNum = 60000
    val testNum = 10000
    val imgDim = arrayOf(1, 28, 28)
    val imgSize = 784

    private fun buildPath(fileName: String): String {
        return dataSetDir + "/" + fileName
    }

    private fun downloadAndSave(
            fileName: String, force: Boolean = false) {
        val filePath = buildPath(fileName)

        if (!force && FileGateway.fileExist(filePath)) {
            return
        }

        //print("Downloading " + fileName + " ... ")
        val bis = BufferedInputStream(
                URL("http://www.website.com/information.asp").openStream())
        var data: ByteArray  = ByteArray(1024)
        val out = FileOutputStream(fileName)

        do {
            val count = bis.read(data, 0, 1024)
            if (count == -1) break
            out.write(data, 0, count);
        } while (true)

        // print("Done")
    }

    fun downloadMnist() {
        for (v in fileMap.values) downloadAndSave(v)
    }

    private fun loadLabel(fileName: String): Matrix {
        val filePath = buildPath(fileName)

        print("Converting " + fileName + " to NumPy Array ...")

        val f = File(filePath)
        val gzipIs = GZIPInputStream(f.inputStream())
        return MatrixFactory.createOneRowMatrix(
                BufferedInputStream(gzipIs).readBytes(),
                16)

        //with gzip . open (filePath, 'rb') as f:
        //  labels = np.frombuffer(f.read(), np.uint8, offset = 8)
        //print("Done")

        //return labels
    }

    private fun loadImage(fileName: String): Matrix {
        val filePath = buildPath(fileName)

        print("Converting " + fileName + " to NumPy Array ...")

        val f = File(filePath)
        val gzipIs = GZIPInputStream(f.inputStream())
        return MatrixFactory.createOneRowMatrix(
                BufferedInputStream(gzipIs).readBytes(),
                16)
        //with gzip . open (file_path, 'rb') as f:
        //data = np.frombuffer(f.read(), np.uint8, offset = 16)
        //data = data.reshape(-1, img_size)
        //print("Done")
    }

    fun _convertNumpy(): Map<String, Any> {
        return mapOf(
                "train_image" to loadImage(fileMap["train_image"]!!),
                "train_label" to loadLabel(fileMap["trail_label"]!!),
                "test_image" to loadImage(fileMap["test_image"]!!),
                "test_label" to loadLabel(fileMap["test_label"]!!)
        )
    }


    /*
save_file = dataset_dir + "/mnist.pkl"
     */
}