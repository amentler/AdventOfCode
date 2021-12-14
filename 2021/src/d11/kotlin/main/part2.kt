package d11p2

import parsing.map2d
import parsing.to2dIntArray
import java.util.*


fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd11")?.readText() as String
    val lines = fileContent.to2dIntArray()
    println(part2(lines, 1000))
}

fun part2(octopuses: Array<Array<Int>>, steps: Int): Int {
    var octos = octopuses
    for (generationIndex in 0 until steps) {
        val dayQueue = LinkedList<(QueueEntry) -> Unit>()
        octopuses.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, number ->
                dayQueue.add(propagate(rowIndex, colIndex))
            }
        }

        while (dayQueue.size > 0) {
            dayQueue.remove()(QueueEntry(octos, dayQueue))
        }
        octos = octos.map2d {
            Math.min(10, it) % 10
        }

        if (octos.flatten().sum() == 0) return generationIndex + 1
    }
    return 0
}

fun propagate(rowIndex: Int, colIndex: Int): ((QueueEntry) -> Unit) {
    return { entry: QueueEntry ->
        entry.Octopuses[rowIndex][colIndex] += 1
        if (entry.Octopuses[rowIndex][colIndex] == 10) {
            entry.Octopuses
                .AllNeighbours(rowIndex, colIndex)
                .map { propagate(it.first, it.second) }
                .forEach { entry.Queue.add(it) }
        }
    }
}

private fun Array<Array<Int>>.AllNeighbours(rowIndex: Int, colIndex: Int): Sequence<Pair<Int, Int>> = sequence {
    for (o in ((0..this@AllNeighbours.first().size - 1).intersect(rowIndex - 1..rowIndex + 1)))
        for (i in ((0..this@AllNeighbours.size - 1).intersect(colIndex - 1..colIndex + 1)))
            yield(Pair(o, i))
}.filterNot { it == Pair(rowIndex, colIndex) }


data class QueueEntry(
    val Octopuses: Array<Array<Int>>,
    val Queue: LinkedList<(QueueEntry) -> Unit>
)

data class Index(
    val x: Int,
    val y: Int

)