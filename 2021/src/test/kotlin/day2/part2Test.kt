package day2

import calculateDepthForwardProduct2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class part2Test {

    @Test
    fun calculateDepthForwardProduct2Test() {
        val expected = 900
        val input = listOf("forward 5","down 5","forward 8","up 3","down 8","forward 2")

        val actual = calculateDepthForwardProduct2(input)

        assertEquals(expected, actual)
    }
}