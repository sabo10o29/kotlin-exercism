import java.lang.IllegalArgumentException

class ChangeCalculator(val input: List<Int>) {

    fun computeMostEfficientChange(total: Int): List<Int> {

        val exceptionMessage = "The total $total cannot be represented in the given currency."

        //Exception handling
        when {
            input.isEmpty() || total == 0 -> return emptyList()
            total < 0 -> throw IllegalArgumentException("Negative totals are not allowed.")
            total < input.min()!! -> throw IllegalArgumentException(exceptionMessage)
        }

        //Initialize
        val coinList = input.filter { i -> i <= total }.sorted()
        val dp = MutableList(coinList.size) { MutableList(total + 1) { i -> if (i == 0) 0 else null } }

        //Calculate minimum number of coins
        (0 until coinList.size).forEach { coinInd ->
            (1..total).forEach { amount ->
                val coin = coinList[coinInd]
                val priorYVal = if (dp.getOrNull(coinInd - 1) != null) dp.getOrNull(coinInd - 1)!![amount] else null
                if (amount < coin) {
                    dp[coinInd][amount] = priorYVal
                } else {
                    val priorXVal = dp[coinInd][amount - coin]
                    dp[coinInd][amount] = if (priorXVal != null) min(priorXVal + 1, priorYVal) else priorYVal
                }
            }
        }

        return requireNotNull(getCoinPattern(dp, coinList)) { exceptionMessage }

    }

    private fun min(v1: Int?, v2: Int?): Int? {
        return listOfNotNull(v1, v2).min()
    }

    private fun getCoinPattern(dp: List<List<Int?>>, coinList: List<Int>): List<Int>? {

        if (dp.last().last() == null) return null

        val result = mutableListOf<Int>()
        var i = dp[0].lastIndex
        var j = dp.indexOf(dp.minBy { list -> if (list.last() != null) list.last()!! else Int.MAX_VALUE })

        while (0 < i && -1 < j) {
            result.add(coinList[j])
            i -= coinList[j]
            val tmpY = dp.indexOf(dp.find { list -> list[i] != null && list[i] == dp[j][i] })
            if (tmpY != -1) j = tmpY
        }
        return result.sorted()
    }


//    private fun showDP(arr: List<List<Int?>>){
//        for(j in arr){
//            val b = StringBuffer()
//            b.append("[ ")
//            for(i in j){
//                when{
//                    i == null -> b.append(" *   ")
//                    i/10==0   -> b.append(" $i   ")
//                    i/100==0  -> b.append(" $i  ")
//                    else      -> b.append(" $i ")
//                }
//            }
//            b.append(" ]")
//            println(b.toString())
//        }
//    }

}
