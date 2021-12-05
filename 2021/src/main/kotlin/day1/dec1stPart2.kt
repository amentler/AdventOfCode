import java.util.*

fun main() {

    val fileContent = object {}.javaClass.getResource("/day1/input1").readText()
    val numbers = fileContent.split("\r\n").map { it.toInt() }

    val counter = countRollingAvgIncrease(numbers)

    println(counter)
}

fun countRollingAvgIncrease(numbers: List<Int>): Int {
    var counter = 0

    val list = LinkedList<Int>()
    list.add(0)
    list.add(0)
    list.add(0)

    list[0] += numbers[0]
    list[0] += numbers[1]
    list[1] += numbers[1]
    list[0] += numbers[2]
    list[1] += numbers[2]
    list[2] += numbers[2]

    for (i in 3 until numbers.size) {
        list[1] += numbers[i]

        if (list[1] > list[0])
            counter++

        list.remove()
        list.add(0)

        list[1] += numbers[i]
        list[2] += numbers[i]
    }

    return counter
}