package d11p1

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd11")?.readText() as String

    val lines = transformInput(fileContent)
    println(part1(lines))
}

fun transformInput(fileContent: String): Any {
    return 0
}

fun part1(lines: Any) {

}
