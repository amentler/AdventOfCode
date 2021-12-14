package d7p2.test

import d7p1.transformInput
import d7p2.calculateDeltaFuel
import d7p2.calculateTotalFuel
import d7p2.part2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part2KtTest {

    @Test
    fun part1() {
        val expected = 168
        val fileContent = object {}.javaClass.getResource("/inputd7")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateTotalFuel2() {
        val expected = 206
        val fileContent = object {}.javaClass.getResource("/inputd7")?.readText() as String

        val input = transformInput(fileContent)
        val actual = calculateTotalFuel(input,2)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateDeltaFuel4() {
        val expected = 10

        val actual = calculateDeltaFuel(4)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateDeltaFuel0() {
        val expected = 0

        val actual = calculateDeltaFuel(0)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateDeltaFuel1() {
        val expected = 1

        val actual = calculateDeltaFuel(1)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateDeltaFuel2() {
        val expected = 3

        val actual = calculateDeltaFuel(2)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateDeltaFuel9() {
        val expected = 45

        val actual = calculateDeltaFuel(9)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateDeltaFuel11() {
        val expected = 66

        val actual = calculateDeltaFuel(11)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateDeltaFuel5() {
        val expected = 15

        val actual = calculateDeltaFuel(5)

        assertEquals(expected, actual)
    }
}