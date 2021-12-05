import java.lang.Exception

fun main() {
    val fileContent = object {}.javaClass.getResource("/day2/input1").readText()
    val directions = fileContent.split("\r\n")

    println(calculateDepthForwardProduct2(directions))
}

fun calculateDepthForwardProduct2(directions: List<String>): Int {
    var aim = 0
    var depth = 0
    var horizontal = 0
    directions.forEach {
        val splitted = it.split(" ")
        val value = splitted[1].toInt()
        when (splitted[0]) {
            "forward" -> {
                horizontal += value
                depth += aim * value
            }
            "up" -> aim -= value
            "down" -> aim += value
            else -> throw Exception()
        }
    }
    return depth * horizontal
}