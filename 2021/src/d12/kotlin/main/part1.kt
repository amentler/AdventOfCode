package d12p1

var result = mutableListOf<List<Edge>>()

val START = "start"
val ENDE = "end"

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd12")?.readText() as String

    val lines = transformInput(fileContent)
    println(part1(lines))
}

fun transformInput(fileContent: String): List<Edge> {
    return fileContent.split(System.lineSeparator())
        .map {
            it.split("-")
                .let { listOf(Edge(it[0], it[1]), Edge(it[1], it[0])) }
        }.flatten()
}

fun part1(edges: List<Edge>): Int {
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

    if (isLowerCase(node) && route.any { it.start == node }) {
        return
    }

    edges.filter { it.start == node }.forEach {
        val subRoute = route.toMutableList()
        subRoute.add(it)
        follow(it.end, subRoute, edges)
    }
}

fun isLowerCase(node: String): Boolean {
    return node.lowercase() == node
}

data class Edge(
    val start: String,
    val end: String
)