import java.lang.NumberFormatException

object Luhn{

    fun isValid(str: String): Boolean{

        val num = str.reversed().replace(" ", "")
        if(num.length<2 || !Regex("[0-9]+").matches(num)) return false

        var sum = 0
        num.forEachIndexed{i, c ->
            val v = Integer.parseInt(c.toString())
            if((i+1)%2 == 0) if(2*v>9) sum += 2*v - 9 else sum += 2*v else sum += v
        }
        return sum%10 == 0
    }
}