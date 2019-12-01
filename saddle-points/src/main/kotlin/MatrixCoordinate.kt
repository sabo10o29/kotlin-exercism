data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(val matrix: List<List<Int>>){

    val saddlePoints = saddlePoint()

    private fun saddlePoint(): Set<MatrixCoordinate>{

        if(matrix.isEmpty()) return emptySet()

        val result = mutableSetOf<MatrixCoordinate>()
        for((y, l) in matrix.withIndex()){
            for((x, v) in l.withIndex()){
                if(isSaddlePoint(x, y))result.add(MatrixCoordinate(y, x))
            }
        }

        return result
    }

    private fun isSaddlePoint(x: Int, y: Int): Boolean{
        val min = matrix.flatten().filterIndexed{i, v -> (i-x)%matrix[0].size==0}.min()
        val max = matrix[y].max()
        return min != null && max != null && min == matrix[y][x] && max == matrix[y][x]
    }


}
