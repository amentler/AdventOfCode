package day5

import Coordinate
import Line
import countOverlapsPart2
import getCoordinatesFromStartToEndPart2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import transformInput


internal class d5part2ktTest {

    @Test
    fun getCoordinatesFromStartToEndTest2() {
        val expected = listOf(Coordinate(0, 0), Coordinate(1, 1), Coordinate(2, 2))
        val input = Line(Coordinate(0, 0), Coordinate(2, 2))

        val actual = getCoordinatesFromStartToEndPart2(input)

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun countOverlapsTest() {
        val expected = 12
        val fileContent = object {}.javaClass.getResource("/day5/input")?.readText() as String

        val input = transformInput(fileContent)

        val actual = countOverlapsPart2(input)

        Assertions.assertEquals(expected, actual)
    }
}