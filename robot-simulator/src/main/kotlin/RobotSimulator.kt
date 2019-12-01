class Robot(var gridPosition: GridPosition = GridPosition(0, 0), var orientation: Orientation = Orientation.NORTH) {

    fun advance() {
        when(orientation){
            Orientation.NORTH -> gridPosition = GridPosition(gridPosition.x, gridPosition.y + 1)
            Orientation.SOUTH -> gridPosition = GridPosition(gridPosition.x, gridPosition.y - 1)
            Orientation.EAST  -> gridPosition = GridPosition(gridPosition.x + 1, gridPosition.y)
            Orientation.WEST  -> gridPosition = GridPosition(gridPosition.x - 1, gridPosition.y)
        }
    }

    fun turnLeft() {
        when(orientation){
            Orientation.NORTH -> orientation = Orientation.WEST
            Orientation.SOUTH -> orientation = Orientation.EAST
            Orientation.EAST -> orientation = Orientation.NORTH
            Orientation.WEST -> orientation = Orientation.SOUTH
        }
    }

    fun turnRight() {
        when(orientation){
            Orientation.NORTH -> orientation = Orientation.EAST
            Orientation.SOUTH -> orientation = Orientation.WEST
            Orientation.EAST -> orientation = Orientation.SOUTH
            Orientation.WEST -> orientation = Orientation.NORTH
        }
    }

    fun simulate(instructions: String) {
        instructions.toCharArray().forEach {
            when(it){
                'A' -> advance()
                'L' -> turnLeft()
                'R' -> turnRight()
                else -> IllegalArgumentException()
            }
        }
    }
}
