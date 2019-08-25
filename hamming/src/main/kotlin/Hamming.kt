import java.util.stream.Stream

object Hamming{
    fun compute(dna1: String, dna2: String): Int{

        if(dna1.length != dna2.length)
            throw IllegalArgumentException("left and right strands must be of equal length.")

        var count = 0
        for(i in 0..dna1.length-1){
            if(dna1[i]!=dna2[i])
                count++
        }
        return count
    }
}