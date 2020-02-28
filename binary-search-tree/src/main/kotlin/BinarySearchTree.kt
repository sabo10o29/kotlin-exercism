class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, var left: Node<T>?, var right: Node<T>?){
        constructor(data: T) : this(data, null, null)

        fun levelList(): List<T>{
            val result = mutableListOf<T>()
            left?.let { result.add( it.data) }
            right?.let { result.add( it.data) }
            left?.let { result.addAll( it.levelList()) }
            right?.let { result.addAll( it.levelList()) }
            return result
        }

        fun sortList(): List<T>{
            val result = mutableListOf<T>()
            left?.let { result.addAll(it.sortList()) }
            result.add(data)
            right?.let{result.addAll( it.sortList() )}
            return result
        }
    }

    var root: Node<T>? = null

    fun insert(value: T) {
        root?.also { recInsert(value, it) }?: run{root = Node(value)}
    }

    private fun recInsert(data: T, node: Node<T>){
        if(data > node.data){
            node.right?.also { recInsert(data, it) }?: run{node.right = Node(data)}
        }else if(data <= node.data){
            node.left?.also { recInsert(data, it) }?: run{node.left = Node(data)}
        }
    }

    fun asSortedList() = root?.sortList() ?: emptyList<T>()

    fun asLevelOrderList() = root?.let {
            val result = mutableListOf<T>(it.data)
            result.addAll(it.levelList())
            return result
        }?: emptyList<T>()

}
