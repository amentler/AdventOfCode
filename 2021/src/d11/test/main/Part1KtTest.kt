package d11p1.test

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import parsing.to2dIntArray

internal class Part1KtTest {

    @Test
    fun part1() {
        val expected = 1656
        val fileContent = object {}.javaClass.getResource("/inputd11")?.readText() as String

        val lines = fileContent.to2dIntArray()
        val actual = d11p1.part1(lines, 100)

        assertEquals(expected, actual)
    }
    @Test
    fun part1_testinput2() {
        val expected = 9
        val fileContent = object {}.javaClass.getResource("/inputd11-2")?.readText() as String

        val lines = fileContent.to2dIntArray()
        val actual = d11p1.part1(lines, 2)

        assertEquals(expected, actual)
    }
    @Test
    fun part1_testinputTest4() {
        val expected = 6
        val fileContent = object {}.javaClass.getResource("/inputd11-3")?.readText() as String

        val lines = fileContent.to2dIntArray()
        val actual = d11p1.part1(lines, 2)

        assertEquals(expected, actual)
    }
}