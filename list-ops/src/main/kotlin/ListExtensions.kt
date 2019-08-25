

fun <T> List<T>.customAppend(list: List<T>): List<T>{
    if(list.isEmpty()) return this
    if(this.isEmpty()) return list

    val result = mutableListOf<T>()

    for(e in this){
        result.add(e)
    }
    for(e in list){
        result.add(e)
    }
    return result
}

fun <T> List<List<T>>.customConcat(): List<T>{
    if(this.isEmpty()) return emptyList()
    return this.flatMap { it }
}

fun <T> List<T>.customFilter(comparator: (T) -> Boolean): List<T>{
    if(this.isEmpty()) return this
    val result = mutableListOf<T>()
    for(e in this){
        if(comparator(e)) result.add(e)
    }
    return result
}

val <T> List<T>.customSize: Int
    get(){
        if(this.isEmpty()) return 0
        var count = 0
        this.forEach{count++}
        return count
    }

fun <T> List<T>.customMap(operator: (T) -> T): List<T>{
    if(this.isEmpty()) return this
    val result = mutableListOf<T>()
    for(e in this){
        result.add(operator(e))
    }
    return result
}

tailrec fun <T,V> List<T>.customFoldRight(initialValue: V, operator: (T, V) -> V): V{
    if(this.isEmpty()) return initialValue
    if(this.size == 1) return operator(this[0], initialValue)
    return operator(this[0], this.subList(1,this.size).customFoldRight(initialValue, operator))
}

tailrec fun <T,V> List<T>.customFoldLeft(initialValue: V, operator: (V, T) -> V): V{
    if(this.isEmpty()) return initialValue
    if(this.size == 1) return operator(initialValue,this[0])
    return operator(this.subList(0,this.size -1).customFoldLeft(initialValue, operator),this.customReverse()[0])
}

fun <T> List<T>.customReverse(): List<T>{
    if(this.isEmpty()) return this
    val result = mutableListOf<T>()
    for(i in this.size - 1 downTo 0){
        result.add(this[i])
    }
    return result
}

