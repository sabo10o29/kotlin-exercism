const val SUFFIX = ", one for me."
const val PREFIX = "One for "

fun twofer(): String {
    return PREFIX + "you" + SUFFIX
}

fun twofer(str: String): String {
    return PREFIX + str + SUFFIX
}