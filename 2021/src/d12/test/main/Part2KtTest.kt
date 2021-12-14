package d12p2.test

import d12p2.Edge
import d12p2.transformInput
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part2KtTest {


    @Test
    fun part2() {
        val expected = 36
        val fileContent = object {}.javaClass.getResource("/inputd12")?.readText() as String

        val edges = transformInput(fileContent)
        val actual = d12p2.part2(edges)

        assertEquals(expected, actual)
    }

    @Test
    fun isValid_B_Then_End() {
        val expected = true
        val input = mutableListOf(
            Edge("start", "A"),
            Edge("A", "b"),
            Edge("b", "end")
        )
        val actual = d12p2.isValid(input)

        assertEquals(expected, actual)
    }

    @Test
    fun isValid_Once_B_Again_B_Valid() {
        val expected = true
        val input = mutableListOf(
            Edge("start", "A"),
            Edge("A", "b"),
            Edge("b", "A"),
            Edge("A", "b"),
        )
        val actual = d12p2.isValid(input)

        assertEquals(expected, actual)
    }

    @Test
    fun isValid_Multiple_B_Valid() {
        val expected = true
        val input = mutableListOf(
            Edge("start", "A"),
            Edge("A", "b"),
            Edge("b", "A"),
            Edge("A", "b"),
            Edge("b", "A"),
        )
        val actual = d12p2.isValid(input)

        assertEquals(expected, actual)
    }

    @Test
    fun isValid_Multiple_B_Again_B_invalid() {
        val expected = false
        val input = mutableListOf(
            Edge("start", "A"),
            Edge("A", "b"),
            Edge("b", "A"),
            Edge("A", "b"),
            Edge("b", "A"),
            Edge("A", "b"),
        )
        val actual = d12p2.isValid(input)

        assertEquals(expected, actual)
    }

    @Test
    fun isValid_Multiple_B_Multiple_C_invalid() {
        val expected = false
        val input = mutableListOf(
            Edge("start", "A"),
            Edge("A", "b"),
            Edge("b", "A"),
            Edge("A", "b"),
            Edge("b", "A"),
            Edge("A", "c"),
            Edge("c", "A"),
            Edge("A", "c"),
        )
        val actual = d12p2.isValid(input)

        assertEquals(expected, actual)
    }

    @Test
    fun isValid_Multiple_B_First_C_valid() {
        val expected = true
        val input = mutableListOf(
            Edge("start", "A"),
            Edge("A", "b"),
            Edge("b", "A"),
            Edge("A", "b"),
            Edge("b", "A"),
            Edge("A", "c")
        )
        val actual = d12p2.isValid(input)

        assertEquals(expected, actual)
    }
}