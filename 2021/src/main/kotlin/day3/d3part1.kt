fun main() {
    val fileContent = object {}.javaClass.getResource("/day3/input").readText()
    val diagnostics = fileContent.split("\r\n")

    println(calculatePowerConsumption(diagnostics))
}

fun calculatePowerConsumption(diagnostics: List<String>): Int {
    val calculation = IntArray(diagnostics[0].length ) {0}
    diagnostics.forEach() {
        it.forEachIndexed {index, c ->
            calculation[index] += c.digitToInt()
        }
    }

    var gamma = ""
    var epsilon = ""
    val limit0 = diagnostics.size / 2

    calculation.forEach{
        if (it > limit0) {
            gamma += '1'
            epsilon += '0'
        } else {
            gamma += '0'
            epsilon += '1'
        }
    }

    return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
}