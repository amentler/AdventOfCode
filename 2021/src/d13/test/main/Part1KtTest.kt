package d13p1.test

import d13p1.transformFoldInstructions
import d13p1.transformSheetInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Part1KtTest {

    @Test
    fun part1() {

        val expected = 16
        val fileContent = object {}.javaClass.getResource("/inputd13.txt")?.readText() as String
        val fileContentInstructions = object {}.javaClass.getResource("/inputd13-2.txt")?.readText() as String

        val sheet = transformSheetInput(fileContent)
        val instructions = transformFoldInstructions(fileContentInstructions)
        val actual = d13p1.part1(sheet, instructions)

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun part12() {

        val expected = 17
        val fileContent = object {}.javaClass.getResource("/inputd13.txt")?.readText() as String
        val fileContentInstructions = object {}.javaClass.getResource("/inputd13-3.txt")?.readText() as String

        val sheet = transformSheetInput(fileContent)
        val instructions = transformFoldInstructions(fileContentInstructions)
        val actual = d13p1.part1(sheet, instructions)

        Assertions.assertEquals(expected, actual)
    }
}