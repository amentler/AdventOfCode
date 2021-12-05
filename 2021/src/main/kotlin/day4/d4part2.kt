import java.lang.Exception

fun main() {
    val fileContent = object {}.javaClass.getResource("/day4/input")?.readText() as String

    val parsed = transformBingoBoard(fileContent)
    println(playBingo42(parsed.first, parsed.second))
}

fun playBingo42(input: List<List<MutableList<Int>>>, numbers: List<Int>): Int {

    return playTillBingo(numbers, input)
}

private fun playTillBingo(
    numbers: List<Int>,
    input: List<List<MutableList<Int>>>
): Int {
    val colEntries = mutableListOf<Entry>()
    val rowEntries = mutableListOf<Entry>()
    var boardIDs = (0..input.size - 1).toList()

    numbers.forEach {
        input.forEachIndexed { boardIndex, board ->
            board.forEachIndexed { lineIndex, line ->
                line.forEachIndexed { itemIndex, item ->
                    if (item == it) {
                        val colEntry =
                            colEntries.filter { it.BoardIndex == boardIndex && it.Index == itemIndex }.firstOrNull()
                        if (colEntry != null) {
                            colEntry.Count += 1
                        } else {
                            colEntries.add(Entry(boardIndex, itemIndex, 1))
                        }
                        val rowEntry =
                            rowEntries.filter { it.BoardIndex == boardIndex && it.Index == lineIndex }.firstOrNull()
                        if (rowEntry != null) {
                            rowEntry.Count += 1
                        } else {
                            rowEntries.add(Entry(boardIndex, lineIndex, 1))
                        }

                        input[boardIndex][lineIndex][itemIndex] = -1
                        if ((rowEntry?.Count == 5 || colEntry?.Count == 5)) {
                            boardIDs = boardIDs.filter { it != boardIndex }
                            val winningNumber = calculateWinningNumber(WinningInfo(boardIndex, it), input)
                            if (boardIDs.size == 0)
                                return winningNumber
                        }
                    }
                }
            }
        }
    }
    throw Exception("fehler")
}
