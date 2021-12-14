package d11p2.test

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import parsing.to2dIntArray

internal class Part2KtTest {


    @Test
    fun part2() {
        val expected = 195
        val fileContent = object {}.javaClass.getResource("/inputd11")?.readText() as String

        val lines = fileContent.to2dIntArray()
        val actual = d11p2.part2(lines, 196)

        assertEquals(expected, actual)
    }
}