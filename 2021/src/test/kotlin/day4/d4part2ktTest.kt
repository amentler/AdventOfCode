package day3

import transformBingoBoard
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import playBingo42

internal class d4part2ktTest {

    @Test
    fun playBingoTest() {
        val expected = 1924
        val fileContent = object {}.javaClass.getResource("/day4/input")?.readText() as String

        val parsed = transformBingoBoard(fileContent)
        val actual = playBingo42(parsed.first, parsed.second)

        assertEquals(expected, actual)
    }
}