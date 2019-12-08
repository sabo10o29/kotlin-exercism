object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {

        if(list.isEmpty()) throw NoSuchElementException("The list is empty list.")

        var subList = list
        var result = 0
        while(subList.size > 1) {
            var i = subList.size / 2
            var v = subList[i]
            when {
                item == v -> return result + i
                item < v -> {
                        subList = subList.subList(0, i)
                    }
                item > v -> {
                        subList = subList.subList(i, subList.size)
                        result += i
                    }
                else -> throw IllegalStateException("")
            }
        }
        return if(subList[0] == item) 0 else throw NoSuchElementException("The item can't be found in the list.")
    }
}
