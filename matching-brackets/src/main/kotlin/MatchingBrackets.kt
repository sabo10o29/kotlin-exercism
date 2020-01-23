object MatchingBrackets {

    fun isValid(input: String): Boolean {
        if(input.isBlank()) return true

        var tmp = input.replace("[^(){}\\[\\]]".toRegex(),"")
        if(tmp.length % 2 != 0) return false

        repeat(tmp.length/2){
            tmp = tmp.replace("\\{\\}".toRegex(),"")
                    .replace("\\(\\)".toRegex(),"")
                    .replace("\\[\\]".toRegex(),"")
        }

        return tmp.isBlank()

    }
}
