import java.lang.IllegalArgumentException

class Triangle(a: Double, b: Double, c: Double){

    constructor(a:Int, b: Int, c: Int): this(a.toDouble(), b.toDouble(), c.toDouble())

    init{
        if(!(a + b > c && a + c > b && c + b > a)) throw IllegalArgumentException()
    }

    var isEquilateral =  if(a == b) b == c else false
    var isIsosceles = if(a == b) true else if(b == c) true else if(a == c) true else false
    var isScalene = !isIsosceles

}