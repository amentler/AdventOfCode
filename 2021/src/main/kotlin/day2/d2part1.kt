fun main() {
    val fileContent = object {}.javaClass.getResource("/day2/input1").readText()
    val directions = fileContent.split("\r\n")

    println(calculateDepthForwardProduct(directions))
}

fun calculateDepthForwardProduct(directions: List<String>): Int {
    return directions.partition { it.startsWith("forward") }
        .run {
            val forwardSum = first.sumOf { it.removePrefix("forward").trim().toInt() }
            val upSum = second.partition { it.startsWith("up") }.run {
                val upSum = first.sumOf { it.removePrefix("up").trim().toInt() }
                val downSum = second.sumOf { it.removePrefix("down").trim().toInt() }
                downSum - upSum
            }
            forwardSum * upSum
        }
}