import java.lang.RuntimeException

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if(naturalNumber <= 0) throw RuntimeException()

    var sum = 0
    for(i in 1.. (naturalNumber/2)){
        if(naturalNumber%i == 0) sum += i
    }

    return when{
        sum == naturalNumber -> Classification.PERFECT
        sum > naturalNumber  -> Classification.ABUNDANT
        sum < naturalNumber  -> Classification.DEFICIENT
        else                 -> throw RuntimeException()
    }
}