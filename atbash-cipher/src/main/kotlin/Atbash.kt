object Atbash {

    fun encode(input: String) = input.toLowerCase().filter(Char::isLetterOrDigit).map(Atbash::replace).chunked(5).joinToString(" "){ chars -> String(chars.toCharArray()) }
    fun decode(input: String) = input.filter(Char::isLetterOrDigit).map(Atbash::replace).joinToString("")
    private val base = 'a'.toInt() + 'z'.toInt()
    private fun replace(c: Char) = if(c in 'a'..'z') (base - c.toInt()).toChar() else c

}