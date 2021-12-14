package d6p2.test

import d6p2.transformInput
import d6p2.part2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigInteger

internal class Part2KtTest {

    @Test
    fun part2Test1_0() {
        val expected: Long = 1
        val actual = part2(listOf(0), 0)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test1_1() {
        val expected: Long = 2
        val actual = part2(listOf(0), 1)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test1_6() {
        val expected: Long = 2
        val actual = part2(listOf(0), 6)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test1_7() {
        val expected: Long = 2
        val actual = part2(listOf(0), 7)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test1_8() {
        val expected: Long = 3
        val actual = part2(listOf(0), 8)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test1_9() {
        val expected: Long = 3
        val actual = part2(listOf(0), 9)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test1_10() {
        val expected: Long = 4
        val actual = part2(listOf(0), 10)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test0() {
        val expected: Long = 5
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input, 0)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test1() {
        val expected: Long = 5
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input, 1)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test2() {
        val expected: Long = 6
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input, 2)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test3() {
        val expected: Long = 7
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input, 3)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test7() {
        val expected: Long = 10
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input, 7)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test8() {
        val expected: Long = 10
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input, 8)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test9() {
        val expected: Long = 11
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input, 9)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test10() {
        val expected: Long = 12
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input, 10)

        assertEquals(expected, actual)
    }

    @Test
    fun part2Test18() {
        val expected: Long = 26
        val fileContent = object {}.javaClass.getResource("/input")?.readText() as String

        val input = transformInput(fileContent)
        val actual = part2(input, 18)

        assertEquals(expected, actual)
    }
}