object Pangram{
    fun isPangram(str: String): Boolean {
        for (c in 'a'..'z'){
            if(!str.contains(c, ignoreCase = true)){
                return false
            }
        }
        return true
    }
}