import java.lang.IllegalArgumentException

object Prime{
    fun nth(n : Int): Int{
        if(n<=0) throw IllegalArgumentException("There is no zeroth prime.")
        for((index, value) in PrimeNumber().withIndex()){
            if (index+1 == n) return value
        }
        throw ArithmeticException("Failed to get nth prime number.")
    }

}

class PrimeNumber: Iterable<Int>, Iterator<Int>{

    val MAX_SIZE=2000000
    val arr = IntArray(MAX_SIZE){i->i}
    var primeNum = 1

    public fun withIndex(): Iterator<IndexedValue<Int>>{
        return this.iterator().withIndex()
    }

    public override fun iterator(): Iterator<Int>{
        return this
    }

    public override fun hasNext(): Boolean{
        if(primeNum > MAX_SIZE) return false

        for(i in primeNum+1..MAX_SIZE-1){
            if (arr[i]!=0) return true
        }
        return false
    }

    public override fun next(): Int{
        if(primeNum > MAX_SIZE) return throw NoSuchElementException()
        for(i in primeNum+1..MAX_SIZE-1){
            if (arr[i]!=0) {
                primeNum = i
                sieveEratosthenes()
                return primeNum
            }
        }
        return throw NoSuchElementException()
    }

    private fun sieveEratosthenes(){
        for(i in 2..MAX_SIZE){
            var tmp = i * primeNum
            if(tmp < MAX_SIZE) arr[tmp]=0 else break
        }
    }

}