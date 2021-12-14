package d12p2

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd12")?.readText() as String

    val lines = transformInput(fileContent)
    println(part2(lines))
}

fun transformInput(fileContent: String): List<Edge> {
    return fileContent.split(System.lineSeparator())
        .map {
            it.split("-")
                .let { listOf(Edge(it[0], it[1]), Edge(it[1], it[0])) }
        }.flatten().filterNot { it.end == START || it.start == ENDE }
}

var result = mutableListOf<List<Edge>>()

const val START = "start"
const val ENDE = "end"

fun part2(edges: List<Edge>): Int {
    edges.filter { it.start == START }.forEach {
        follow(it.end, mutableListOf(it), edges)
    }

    return result.size
}

fun follow(node: String, route: MutableList<Edge>, edges: List<Edge>) {

    if (route.any { it.end == ENDE }) {
        result.add(route)
        return
    }

    if (isLowerCase(node) && !isValid(route)) return

    edges.filter { it.start == node }.forEach {
        val subRoute = route.toMutableList()
        subRoute.add(it)
        follow(it.end, subRoute, edges)
    }
}

fun isValid(route: MutableList<Edge>): Boolean {
    return route
        .map { listOf(it.start, it.end) }
        .flatten() // (start: "A", ende: "b") -> Ab
        .filter { isLowerCase(it) } // "AbAb"-> bb
        .groupBy { it } //"bbcc" -> "b"/list(bb),"c"/list(cc)
        .filter { it.value.size > 2 } //list(bbb),list(cc) -> list(bbb)
        .map { Pair(it.key, it.value.size) } // "b"/list(bbb), "c"/list(cccc) -> "b" - 3, "c" - 4
        .let { (it.isEmpty()) || (it.size == 1 && it[0].second < 5) }
}

fun isLowerCase(node: String): Boolean {
    return node.lowercase() == node
}

data class Edge(
    val start: String,
    val end: String
)