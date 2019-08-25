object SumOfMultiples{
    fun sum(set: Set<Int>, upperLimit: Int): Int {
        var result = 0
        var cashe = mutableListOf<Int>()

        set.forEach{element ->
            for(i in 1..upperLimit){
                var tmp = element * i
                if(tmp < upperLimit && !cashe.contains(tmp)){
                    result += tmp
                    cashe.add(tmp)
                }else if(tmp >= upperLimit){
                    break
                }
            }
        }
        return result
    }
}