object SpiralMatrix {

    fun ofSize(size: Int): Array<IntArray> {
        val result = Array(size) { IntArray(size) }
        var k = 1
        var xStart = 0
        var xEnd = size - 1
        var yStart = 0
        var yEnd = size - 1

        while (k <= size * size) {
            //top
            (xStart..xEnd).forEach { i ->  result[yStart][i] = k++ }
            //right
            (yStart + 1..yEnd).forEach { i ->  result[i][xEnd] = k++ }
            //bottom
            (xEnd - 1 downTo xStart).forEach { i ->  result[yEnd][i] = k++ }
            //left
            (yEnd - 1 downTo yStart + 1).forEach { i ->  result[i][xStart] = k++ }

            xStart++
            xEnd--
            yStart++
            yEnd--
        }
        return result
    }
}
