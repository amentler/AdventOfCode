package day3

import calculatePowerConsumption
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class d3part1ktTest {

    @Test
    fun calculateDepthForwardProduct31Test() {
        val expected = 198
        val input = listOf("00100","11110","10110","10111","10101","01111","00111","11100","10000","11001","00010","01010")

        val actual = calculatePowerConsumption(input)

        assertEquals(expected, actual)
    }
}