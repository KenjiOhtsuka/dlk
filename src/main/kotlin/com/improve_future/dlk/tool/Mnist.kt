package com.improve_future.dlk.tool

object Mnist {
    val urlBase = "http://yann.lecun.com/exdb/mnist/"

    val fileMap: Map<String, String> = mapOf(
            "train_image" to "train-images-idx3-ubyte.gz",
            "train_label" to "train-labels-idx1-ubyte.gz",
            "test_image" to "t10k-images-idx3-ubyte.gz",
            "test_label" to "t10k-labels-idx1-ubyte.gz"
    )

    val datasetDir = os.path.dirname(os.path.abspath(__file__))


    val trainNum = 60000
    val testNum = 10000
    val imgDim = arrayOf(1, 28, 28)
    val imgSize = 784

    private fun buildPath(fileName: String): String {
        return datasetDir + "/" + fileName
    }

    private fun download(fileName: String, force: Boolean = false) {
        val filePath = buildPath(fileName)

        if (!force)
            // exit when the file exists
        if os.path.exists(filePath)
        return

        print("Downloading " + fileName + " ... ")
        // download the file and save it to the path
        urllib.request.urlretrieve(urlBase + fileName, filePath)
        print("Done")
    }

    fun downloadMnist() {
        for (v in fileMap.values) download(v)
    }

    private fun loadLabel(fileName: String) {
        val filePath = buildPath(fileName)

        print("Converting " + fileName + " to NumPy Array ...")
        with gzip . open (file_path, 'rb') as f:
        labels = np.frombuffer(f.read(), np.uint8, offset = 8)
        print("Done")

        return labels
    }

    private fun loadImage(fileName: String) {
        val filePath = buildPath(fileName)

        print("Converting " + fileName + " to NumPy Array ...")
        with gzip . open (file_path, 'rb') as f:
        data = np.frombuffer(f.read(), np.uint8, offset = 16)
        data = data.reshape(-1, img_size)
        print("Done")

        return data
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


def _load_label(file_name):
    file_path = dataset_dir + "/" + file_name

    print("Converting " + file_name + " to NumPy Array ...")
    with gzip.open(file_path, 'rb') as f:
            labels = np.frombuffer(f.read(), np.uint8, offset=8)
    print("Done")

    return labels

def _load_img(file_name):
    file_path = dataset_dir + "/" + file_name

    print("Converting " + file_name + " to NumPy Array ...")
    with gzip.open(file_path, 'rb') as f:
            data = np.frombuffer(f.read(), np.uint8, offset=16)
    data = data.reshape(-1, img_size)
    print("Done")

    return data
     */
}