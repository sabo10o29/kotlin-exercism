import java.lang.IllegalStateException
import kotlin.random.Random


class Robot {
    companion object {
        const val NUM_OF_RETRY = 1000
        val nameSet = mutableSetOf<String>()
    }

    var name = registRobotName()

    fun registRobotName(): String{
        for(i in 0..NUM_OF_RETRY){
            val result = "${Random.nextInt(65, 90).toChar()}${Random.nextInt(65, 90).toChar()}${Random.nextInt(0, 9)}${Random.nextInt(0, 9)}${Random.nextInt(0, 9)}"
            if(!nameSet.contains(result)){
                nameSet.add(result)
                return result
            }
        }
        throw IllegalStateException("Can't find random name.")
    }

    fun reset() {
        nameSet.clear()
        name = registRobotName()
    }

}
