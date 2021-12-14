package d7p1.test

import d7p1.transformInput
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part1KtTest {

    @Test
    fun part1() {
        val expected = 37
        val fileContent = object {}.javaClass.getResource("/inputd7")?.readText() as String

        val input = transformInput(fileContent)
        val actual = d7p1.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateTotalFuel1() {
        val expected = 41
        val fileContent = object {}.javaClass.getResource("/inputd7")?.readText() as String

        val input = transformInput(fileContent)
        val actual = d7p1.calculateTotalFuel(input,1)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateTotalFuel3() {
        val expected = 39
        val fileContent = object {}.javaClass.getResource("/inputd7")?.readText() as String

        val input = transformInput(fileContent)
        val actual = d7p1.calculateTotalFuel(input,3)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateTotalFuel10() {
        val expected = 71
        val fileContent = object {}.javaClass.getResource("/inputd7")?.readText() as String

        val input = transformInput(fileContent)
        val actual = d7p1.calculateTotalFuel(input,10)

        assertEquals(expected, actual)
    }

    @Test
    fun calculateTotalFuel2() {
        val expected = 37
        val fileContent = object {}.javaClass.getResource("/inputd7")?.readText() as String

        val input = transformInput(fileContent)
        val actual = d7p1.calculateTotalFuel(input,2)

        assertEquals(expected, actual)
    }
}