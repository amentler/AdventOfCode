fun main() {
    val fileContent = object {}.javaClass.getResource("/day3/input").readText()
    val diagnostics = fileContent.split("\r\n")

    println(calculateLifeSupportRating(diagnostics))
}

fun calculateLifeSupportRating(diagnostics: List<String>): Int {
    var oxygenSelectionBucket = diagnostics
    var co2SelectionBucket = diagnostics

    for (index in 0 until diagnostics.size) {
        if (oxygenSelectionBucket.size > 1) {
            oxygenSelectionBucket = oxygenSelectionBucket.filter {
                it[index] ==
                        oxygenSelectionBucket.filter { it[index] == '1' }.count()
                            .run { (compareTo(oxygenSelectionBucket.size - this - 1) + 1) / 2 }.digitToChar();
            }
        }

        if (co2SelectionBucket.size > 1) {
            co2SelectionBucket = co2SelectionBucket.filter {
                it[index] ==
                        co2SelectionBucket.filter { it[index] == '0' }.count()
                            .run { (compareTo(co2SelectionBucket.size - this) + 1) / 2 }.digitToChar();
            }
        }
    }

    return Integer.parseInt(oxygenSelectionBucket[0], 2) * Integer.parseInt(co2SelectionBucket[0], 2)
}