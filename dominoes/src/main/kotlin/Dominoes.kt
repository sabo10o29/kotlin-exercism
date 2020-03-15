class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int)

object Dominoes {

    fun formChain(vararg inputDominoes: Domino): List<Domino> {
        return formChain(inputDominoes.asList())
    }

    fun formChain(inputDominoes: List<Domino>): List<Domino> {
        when(inputDominoes.size){
            0 -> return emptyList()
            1 -> return if(inputDominoes[0].right==inputDominoes[0].left) inputDominoes
                            else throw ChainNotFoundException("singleton can't be chained")
            else -> if(!validDominos(inputDominoes)) throw ChainNotFoundException("can't be chained")
        }

        val firstDomino = inputDominoes.first()
        val result = getDominos(listOf(firstDomino), inputDominoes.subList(firstDomino))
        return result?.toList() ?: throw ChainNotFoundException("can't be chained")
    }

    private fun getDominos(resultDominos: List<Domino>, remainedDominoes: List<Domino>): MutableList<Domino>?{
        if(remainedDominoes.isEmpty()) return resultDominos.toMutableList()

        val tailValue = resultDominos.last().right
        remainedDominoes.forEach { domino ->
            val result = resultDominos.toMutableList()
            when(tailValue){
                domino.left -> result.add(domino)
                domino.right -> result.add(swap(domino))
                else -> return@forEach
            }
            val tmpDominos = getDominos(result, remainedDominoes.subList(domino))
            if(tmpDominos!=null) return tmpDominos
        }
        return null
    }

    fun List<Domino>.subList(domino: Domino): List<Domino>{
        val result = this.toMutableList()
        result.remove(domino)
        return result
    }

    private fun swap(domino : Domino): Domino{
        return Domino(domino.right, domino.left)
    }

    private fun validDominos(dominos: List<Domino>): Boolean{
        val list = dominos.flatMap { domino -> listOf(domino.left, domino.right) }.sorted()
        for(i in list.toSet()){
            if(list.count { v -> v == i } % 2 != 0) return false
        }
        return true
    }
}
