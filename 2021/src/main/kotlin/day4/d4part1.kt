import java.lang.Exception
import kotlin.collections.sumOf as sumOf

fun main() {
    val fileContent = object {}.javaClass.getResource("/day4/input")?.readText() as String

    val parsed = transformBingoBoard(fileContent)
    println(playBingo(parsed.first, parsed.second))
}

fun transformBingoBoard(input: String): Pair<List<List<MutableList<Int>>>, List<Int>> {
    val dividedInput = input.split("\r\n")
    val inputNumbers = dividedInput.toMutableList().removeFirst().split(",").map { it.toInt() }
    val boardStrings = dividedInput.drop(2).filter { it.length > 0 }.chunked(5)

    val boardNumbers = boardStrings.mapIndexed { _, boardString ->
        boardString.mapIndexed { _, lineString ->
            lineString.chunked(3).map { it.trim().toInt() }.toMutableList()
        }
    }

    return Pair(boardNumbers, inputNumbers)
}

fun playBingo(input: List<List<MutableList<Int>>>, numbers: List<Int>): Int {

    val entry = playTillBingo(numbers, input)
    return calculateWinningNumber(entry, input)
}

fun calculateWinningNumber(entry: WinningInfo, input: List<List<MutableList<Int>>>): Int {
    return input[entry.BoardIndex].sumOf { it.filter { it >= 0 }.toIntArray().sumOf { it }} * entry.WinningNumber
}

private fun playTillBingo(
    numbers: List<Int>,
    input: List<List<MutableList<Int>>>
) : WinningInfo{
    val colEntries = mutableListOf<Entry>()
    val rowEntries = mutableListOf<Entry>()
    numbers.forEach {
        input.forEachIndexed { boardIndex, board ->
            board.forEachIndexed { lineIndex, line ->
                line.forEachIndexed { itemIndex, item ->
                    if (item == it) {
                        val colEntry =
                            colEntries.filter { it.BoardIndex == boardIndex && it.Index == itemIndex  }.firstOrNull()
                        if (colEntry != null) {
                            colEntry.Count += 1
                        } else {
                            colEntries.add(Entry(boardIndex, itemIndex , 1))
                        }
                        val rowEntry =
                            rowEntries.filter { it.BoardIndex == boardIndex && it.Index == lineIndex}.firstOrNull()
                        if (rowEntry != null) {
                            rowEntry.Count += 1
                        } else {
                            rowEntries.add(Entry(boardIndex, lineIndex, 1))
                        }

                        input[boardIndex][lineIndex][itemIndex] = -1
                        if (colEntry?.Count == 5|| rowEntry?.Count == 5) return WinningInfo(boardIndex, it)
                    }
                }
            }
        }
    }
    throw Exception("nothing found")
}

class WinningInfo(
    val BoardIndex: Int,
    val WinningNumber: Int,
)

class Entry(
    val BoardIndex: Int,
    val Index: Int,
    var Count: Int,
)
