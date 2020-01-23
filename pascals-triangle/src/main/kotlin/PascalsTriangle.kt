object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {

        if(rows==0) return emptyList()

        val result = mutableListOf<List<Int>>(listOf(1))
        (1 until rows).forEach { i ->
            val item = IntArray(i+1) { j -> if(j==0||j==i) 1 else result[i-1][j] + result[i-1][j-1] }.toList()
            result.add(item)
        }
        return result

    }

}
