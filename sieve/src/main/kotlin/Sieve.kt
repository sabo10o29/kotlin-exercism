private const val MAX_UPPER_BOUND = 3000

object Sieve {

    val list by lazy {
        primeList()
    }

    private fun primeList(): List<Int>{
        val list = (2..MAX_UPPER_BOUND).toMutableList()
        var i = 0
        while( i < list.size ){
            val v = list[i]
            var j = 2
            while(v*j < list.last()){
                list.remove(v*j)
                j++
            }
            i++
        }
        return list.toList()
    }

    fun primesUpTo(upperBound: Int): List<Int> {
        if(upperBound > MAX_UPPER_BOUND) throw IllegalArgumentException("")
        return list.filter { i -> i <= upperBound }
    }
}
