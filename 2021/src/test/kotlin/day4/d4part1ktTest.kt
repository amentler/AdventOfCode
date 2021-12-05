package day3

import playBingo
import transformBingoBoard
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class d4part1ktTest {

    @Test
    fun playBingoTest() {
        val expected = 4512
        val fileContent = object {}.javaClass.getResource("/day4/input")?.readText() as String

        val parsed = transformBingoBoard(fileContent)
        val actual = playBingo(parsed.first, parsed.second)

        assertEquals(expected, actual)
    }
}