enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun <E> List<E>.relationshipTo(list: List<E>): Relationship{
    when{
        this == list    -> return Relationship.EQUAL
        this in list    -> return Relationship.SUBLIST
        list in this    -> return Relationship.SUPERLIST
        else            -> return Relationship.UNEQUAL
    }
}

operator fun <E> List<E>.contains(list: List<E>): Boolean{
    if( this.size < list.size ) return false
    (0..this.size - list.size).forEach {
        if(this.subList(it, it+list.size) == list) return true
    }
    return false
}