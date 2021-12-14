package parsing


inline fun Array<Array<Int>>.map2d(function: (Int) -> Int): Array<Array<Int>> {
    val data = Array(this.size) { Array(this[0].size) { 0 } }
    for (i in 0 until this.size) {
        for (j in 0 until this[0].size) {
            data[i][j] = function(this[i][j])
        }
    }
    return data
}


fun String.to2dIntArray(): Array<Array<Int>> {
    val lines = this.split(System.lineSeparator())
    val result = lines.map { it.map(Char::digitToInt).toTypedArray() }.toTypedArray()
    return result
}