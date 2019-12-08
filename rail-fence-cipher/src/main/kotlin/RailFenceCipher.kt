private const val EMPTY_CHAR = ' '

class RailFenceCipher(val rowNumber: Int) {

    fun getEncryptedData(input: String): String {
        if(input.contains(EMPTY_CHAR)) throw IllegalArgumentException("Un-support space character")
        val fence = createEncryptFence(input)
        return fence.map { arr -> String(arr) }.reduce{a, b -> a + b}.replace(EMPTY_CHAR.toString(), "")
    }

    fun getDecryptedData(input: String): String {
        if(input.contains(EMPTY_CHAR)) throw IllegalArgumentException("Un-support space character")
        val fence = createDecryptFence(input)
        val builder = StringBuilder()
        (0 until input.length).forEach {
            val word = fence.map { str -> str[it] }.find { c -> !EMPTY_CHAR.equals(c) }
            builder.append(word ?: throw IllegalStateException(""))
        }
        return builder.toString()
    }

    private fun createDecryptFence(input: String): List<CharArray>{
        val fence = createEncryptFence(String(CharArray(input.length){'*'}))
        val result = MutableList(rowNumber){CharArray(input.length){EMPTY_CHAR}}
        var count = 0
        (0 until rowNumber).forEach { j ->
            (0 until input.length).forEach{ i ->
                if(fence[j][i].equals('*')){
                    result[j][i] = input[count]
                    count++
                }
            }
        }
        return result.toList()
    }

    private fun createEncryptFence(input: String): List<CharArray> {

        val result = MutableList(rowNumber){CharArray(input.length){EMPTY_CHAR}}
        var y = 0
        var increase = true
        (0 until input.length).forEach {
            result[y][it] = input[it]
            if(y==0) increase = true
            if(y==rowNumber-1) increase = false
            if(increase) y++ else y--
        }
        return result.toList()
    }


}
