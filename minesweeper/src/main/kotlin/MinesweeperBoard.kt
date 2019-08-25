import java.util.*

class MinesweeperBoard(val inputBoard: List<String>){

    val width = if(inputBoard.isEmpty()) 0 else inputBoard[0].length
    val height = if(inputBoard.isEmpty()) 0 else inputBoard.size

    fun withNumbers(): List<String>{

        if(inputBoard.isEmpty()) return emptyList()
        var arr = arrayListOf<String>()

        for(j in 0..height-1){
            var builder = StringBuilder()
            for(i in 0..width-1){
                if(inputBoard[j][i].equals('*')){
                    builder.append('*')
                }else{
                    val num = countMine(i,j)
                    if(num==0) builder.append(' ') else builder.append(num)
                }
            }
            arr.add(builder.toString())
        }
        return arr
    }

    private fun countMine(i: Int, j: Int): Int{

        var result = 0
        for(x in i-1..i+1){
            for(y in j-1..j+1){
                if(validCell(x,y)){
                    var c = inputBoard[y][x]
                    if(c.equals('*')) result++
                }
            }
        }
        return result
    }

    private fun validCell(x: Int, y: Int): Boolean{
        return 0<=x && x<width && 0<=y && y<height
    }



}