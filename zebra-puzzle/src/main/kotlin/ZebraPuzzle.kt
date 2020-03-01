class ZebraPuzzle() {

    enum class POSITION { FIRST, SECOND, THIRD, FORTH, FIFTH }
    enum class COLOR { RED, GREEN, BLUE, YELLOW, CREAM }
    enum class NATIONALITY { SCOTLAND, GREEK, JAPANESE, DANISH, BOLIVIAN }
    enum class DRINK { MILK, ORANGE, WATER, COFFEE, TEA }
    enum class PET { KATATSUMURI, FOX, ZEBRA, HORSE, DOG }
    enum class SHOES { ATSUZOKO, LEATHER_SANDALU, SLIPPA, LEATHER, BEACH_SANDARU }

    val patternList = listOf(
            //house position, house color, nationality, drink, pet, shoes
            listOf(null, COLOR.RED,   NATIONALITY.SCOTLAND,   null,           null,       null),
            listOf(null, null,        NATIONALITY.GREEK,      null,           PET.DOG,    null),
            listOf(null, COLOR.GREEN, null,                   DRINK.COFFEE,   null,       null),
            listOf(null, null,        NATIONALITY.BOLIVIAN,   DRINK.TEA,      null,       null),
            listOf(null, null,        null,                   null,           PET.KATATSUMURI,       SHOES.LEATHER),
            listOf(null, null,        null,                   null,           null,       SHOES.LEATHER_SANDALU),
            listOf(null, null,        null,                   DRINK.ORANGE,   null,       SHOES.SLIPPA),
            listOf(null, null,        NATIONALITY.JAPANESE,   null,           null,       SHOES.BEACH_SANDARU),
            listOf(null, null,        null,                   null,           null,       null)
    )

    fun matchPattern(target: List<Enum<*>>){
        for(list in patternList){
            for((i, enum) in list.withIndex()){
                enum?.name.equals(target[i].name)
            }

        }

    }

    fun drinksWater(): String {
        println(HOUSE_POSITION.FIFTH == HOUSE_POSITION.FIFTH)

        TODO("Implement this function to complete the task")
    }

    fun ownsZebra(): String {
        TODO("Implement this function to complete the task")
    }

}
