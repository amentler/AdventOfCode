package day2

import calculateDepthForwardProduct
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class part1Test {

    @Test
    fun calculateDepthForwardProductTest() {
        val expected = 150
        val input = listOf("forward 5","down 5","forward 8","up 3","down 8","forward 2")

        val actual = calculateDepthForwardProduct(input)

        assertEquals(expected, actual)
    }
}