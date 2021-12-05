package day3

import calculateLifeSupportRating
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class d3part2ktTest {

    @Test
    fun calculateLifeSupportRatingTest() {
        val expected = 230
        val input = listOf("00100","11110","10110","10111","10101","01111","00111","11100","10000","11001","00010","01010")

        val actual = calculateLifeSupportRating(input)

        assertEquals(expected, actual)
    }
}