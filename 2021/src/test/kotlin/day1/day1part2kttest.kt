package day1

import countRollingAvgIncrease
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class day1part2kttest {

    @Test
    fun countRollingAvgIncrease3() {
        val expected = 3
        val input = listOf(1,2,3,4,5,6)

        val actual = countRollingAvgIncrease(input)

        assertEquals(expected, actual)
    }

    @Test
    fun countRollingAvgIncrease1() {
        val expected = 1
        val input = listOf(1,2,3,4)

        val actual = countRollingAvgIncrease(input)

        assertEquals(expected, actual)
    }

    @Test
    fun countRollingAvgIncrease0() {
        val expected = 0
        val input = listOf(1,2,3,1)

        val actual = countRollingAvgIncrease(input)

        assertEquals(expected, actual)
    }
}