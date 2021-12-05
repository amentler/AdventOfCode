package day5

import Coordinate
import Line
import countOverlaps
import getCoordinateFromString
import getCoordinatesFromStartToEnd
import getLineFromString
import getLinesAsString
import playBingo
import transformBingoBoard
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import transformInput

internal class D5part1KtTest1 {

    @Test
    fun getLinesAsStringTest() {
        val expected = 10
        val fileContent = object {}.javaClass.getResource("/day5/input")?.readText() as String

        val actual = getLinesAsString(fileContent).size

        assertEquals(expected, actual)
    }

    @Test
    fun countOverlaps1Test() {
        val expected = 1

        val actual = countOverlaps(
            listOf(
                Line(Coordinate(0, 0), Coordinate(0, 0)),
                Line(Coordinate(0, 0), Coordinate(0, 0))
            )
        )

        assertEquals(expected, actual)
    }

    @Test
    fun countOverlaps2Test() {
        val expected = 0

        val actual = countOverlaps(
            listOf(
                Line(Coordinate(0, 0), Coordinate(0, 0)),
                Line(Coordinate(0, 1), Coordinate(0, 1))
            )
        )

        assertEquals(expected, actual)
    }

    @Test
    fun countOverlaps3Test() {
        val expected = 1

        val actual = countOverlaps(
            listOf(
                Line(Coordinate(1, 0), Coordinate(1, 2)),
                Line(Coordinate(0, 1), Coordinate(2, 1))
            )
        )

        assertEquals(expected, actual)
    }

    @Test
    fun countOverlaps4Test() {
        val expected = 3

        val actual = countOverlaps(
            listOf(
                Line(Coordinate(1, 0), Coordinate(1, 2)),
                Line(Coordinate(1, 0), Coordinate(1, 2))
            )
        )

        assertEquals(expected, actual)
    }

    @Test
    fun countOverlaps5Test() {
        val expected = 3

        val actual = countOverlaps(
            listOf(
                Line(Coordinate(1, 0), Coordinate(1, 2)),
                Line(Coordinate(1, 0), Coordinate(1, 2)),
                Line(Coordinate(0, 2), Coordinate(2, 2))
            )
        )

        assertEquals(expected, actual)
    }

    @Test
    fun countOverlapsTest() {
        val expected = 5
        val fileContent = object {}.javaClass.getResource("/day5/input")?.readText() as String

        val input = transformInput(fileContent)

        val actual = countOverlaps(input)

        assertEquals(expected, actual)
    }

    @Test
    fun getXCoordinatesFromLineTest() {
        val expected = listOf(Coordinate(0, 0), Coordinate(0, 1), Coordinate(0, 2))
        val input = Line(Coordinate(0, 0), Coordinate(0, 2))

        val actual = getCoordinatesFromStartToEnd(input)

        assertEquals(expected, actual)
    }

    @Test
    fun getXCoordinatesFromLineTest2() {
        val expected = listOf(Coordinate(2, 1), Coordinate(3, 1), Coordinate(4, 1), Coordinate(5, 1))
        val input = Line(Coordinate(2, 1), Coordinate(5, 1))

        val actual = getCoordinatesFromStartToEnd(input)

        assertEquals(expected, actual)
    }

    @Test
    fun getXCoordinatesFromLineTest3() {
        val expected = listOf(Coordinate(5, 5))
        val input = Line(Coordinate(5, 5), Coordinate(5, 5))

        val actual = getCoordinatesFromStartToEnd(input)

        assertEquals(expected, actual)
    }

    @Test
    fun getCoordinatesFromStartToEndTest2() {
        val expected = listOf(Coordinate(0, 0), Coordinate(1, 0), Coordinate(2, 0))
        val input = Line(Coordinate(2, 0), Coordinate(0, 0))

        val actual = getCoordinatesFromStartToEnd(input)

        assertEquals(expected, actual)
    }

    @Test
    fun getCoordinatesFromStartToEndTest() {
        val expected = listOf(Coordinate(0, 0), Coordinate(0, 1), Coordinate(0, 2))
        val input = Line(Coordinate(0, 0), Coordinate(0, 2))

        val actual = getCoordinatesFromStartToEnd(input)

        assertEquals(expected, actual)
    }

    @Test
    fun transformInputTest() {
        val fileContent = object {}.javaClass.getResource("/day5/input")?.readText() as String

        val actual = transformInput(fileContent)

        assertEquals(Coordinate(0, 9), actual[0].from)
        assertEquals(Coordinate(5, 9), actual[0].to)
        assertEquals(Coordinate(5, 5), actual.last().from)
        assertEquals(Coordinate(8, 2), actual.last().to)
    }

    @Test
    fun getLineFromStringTest() {
        val expected = Line(Coordinate(0, 9), Coordinate(2, 9))

        val actual = getLineFromString("0,9 -> 2,9")

        assertEquals(expected, actual)
    }

    @Test
    fun getCoordinateFromStringTest() {
        val expected = Coordinate(0, 9)

        val actual = getCoordinateFromString("0,9")

        assertEquals(expected, actual)
    }

    @Test
    fun playBingoTest() {
        val expected = 4512
        val fileContent = object {}.javaClass.getResource("/day4/input")?.readText() as String

        val parsed = transformBingoBoard(fileContent)
        val actual = playBingo(parsed.first, parsed.second)

        assertEquals(expected, actual)
    }
}