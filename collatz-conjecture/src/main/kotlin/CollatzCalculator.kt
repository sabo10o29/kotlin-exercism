import java.lang.IllegalArgumentException

object CollatzCalculator{


    fun computeStepCount(num: Int): Int{

        if(num <= 0) throw IllegalArgumentException("Only natural numbers are allowed")

        var step = 0
        var tmpNum = num

        while(tmpNum != 1){
            if (tmpNum % 2 == 0) tmpNum = tmpNum / 2 else tmpNum = 3 * tmpNum + 1
            step += 1

        }
        return step
    }





}

