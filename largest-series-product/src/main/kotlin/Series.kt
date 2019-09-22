import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class Series(val target: String){

    private val targetDigits = target.length

    init{
        try{
            if(!target.isBlank() && !Regex("[0-9]+").matches(target)) throw IllegalArgumentException()
        }catch (e: NumberFormatException){
            throw IllegalArgumentException()
        }
    }

    fun getLargestProduct(num: Int): Int{

        if(num <0 || targetDigits < num) throw IllegalArgumentException("")
        if(targetDigits == 0) return 1

        var max = 0
        (0..target.length - num).forEach { i ->
            var product = 1
            for(n in target.substring(i, i + num)){
                product *= Integer.parseInt(n.toString())
            }
            if(max<product) max = product
        }
        return max
    }


}