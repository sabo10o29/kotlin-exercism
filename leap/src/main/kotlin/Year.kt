
class Year(private val year: Int){
    val isLeap =
            when {
                year % 4    != 0    -> false
                year % 100  != 0    -> true
                year % 400  != 0    -> false
                else                -> true
            }
}