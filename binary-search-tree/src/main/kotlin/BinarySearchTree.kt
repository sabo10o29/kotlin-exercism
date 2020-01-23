class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, var left: Node<T>?, var right: Node<T>?){
        constructor(data: T) : this(data, null, null)
    }

    var root: Node<T>? = null

    fun insert(value: T) {
        if(root==null){
            root = Node(value)
            return
        }else{
            recInsert(value, root!!)
        }
    }

    private tailrec fun recInsert(data: T, node: Node<T>){
        if(data > node.data){
            if(node.right == null){
                node.right = Node(data)
            }else{
                recInsert(data, node.right!!)
            }
        }else if(data < node.data){
            if(node.left == null){
                node.left = Node(data)
            }else{
                recInsert(data, node.left!!)
            }
        }
    }

    fun asSortedList(): List<T> {
        TODO("Delete this statement and write your own implementation.")
    }

    fun asLevelOrderList(): List<T> {
        TODO("Delete this statement and write your own implementation.")
    }

}
