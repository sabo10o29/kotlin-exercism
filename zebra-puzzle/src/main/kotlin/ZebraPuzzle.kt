class ZebraPuzzle() {

    enum class HOUSE_POSITION { FIRST, SECOND, THIRD, FORTH, FIFTH }
    enum class HOUSE_COLOR { RED, GREEN, YELLOW, BLUE, FIFTH }
    enum class NATIONALITY { SCOTLAND, GREEK, JAPANESE, DENMARK, BORIBIA }
    enum class DRINK { MILK, ORANGE, WATER, COFFEE, TEA }
    enum class PET { KATATSUMURI, FOX, ZEBRA, HOUSE, DOG }
    enum class SHOES { ATSUZOKO, LEATHER_SANDALU, SLIPPA, LEATHER, BEACH_SANDARU }

    val patternList = listOf(
            //house position, house color, nationality, drink, pet, shoes
            listOf(null, HOUSE_COLOR.RED, NATIONALITY.SCOTLAND, null, null, null),
            listOf(null, null, NATIONALITY.GREEK, null, PET.DOG, null),
            listOf(null, HOUSE_COLOR.GREEN, null, DRINK.COFFEE, null, null),
            listOf(null, null, NATIONALITY.BORIBIA, DRINK.TEA, null, null),
            listOf(null, null, null, null, null, null)

    )

    fun drinksWater(): String {
        TODO("Implement this function to complete the task")
    }

    fun ownsZebra(): String {
        TODO("Implement this function to complete the task")
    }

}
