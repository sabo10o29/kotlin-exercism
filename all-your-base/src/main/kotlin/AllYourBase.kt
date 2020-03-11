class BaseConverter(private val base: Int, private val value: IntArray) {

    private var deciVal: Int
    init {
        checkConstructorArgument()
        deciVal = value.reversed().mapIndexed { i, v -> v * Math.pow(base.toDouble(), i.toDouble()) }.sum().toInt()
    }

    fun convertToBase(newBase: Int): IntArray {
        if(newBase < 2) throw IllegalArgumentException("Bases must be at least 2.")

        val result = mutableListOf<Int>()
        var tmp = deciVal
        while(tmp >= newBase){
            result.add(Math.floorMod(tmp, newBase))
            tmp /= newBase
        }
        result.add(tmp)

        return result.reversed().toIntArray()
    }

    private fun checkConstructorArgument(){
        if(base < 2) throw IllegalArgumentException("Bases must be at least 2.")

        when(value.size){
            0 -> throw java.lang.IllegalArgumentException("You must supply at least one digit.")
            1 -> {}
            else -> if(value[0] == 0) throw IllegalArgumentException("Digits may not contain leading zeros.")
        }

        value.forEach { i ->
            when{
                i < 0 -> throw java.lang.IllegalArgumentException("Digits may not be negative.")
                base <= i -> throw IllegalArgumentException("All digits must be strictly less than the base.")
            }
        }
    }

}
