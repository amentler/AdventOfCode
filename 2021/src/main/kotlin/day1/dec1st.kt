fun main() {

    val fileContent = object {}.javaClass.getResource("/day1/input1").readText()
    val numbers = fileContent.split("\r\n").map { it.toInt() }

    var last = numbers[0]
    var counter = 0

    for(number in numbers) {
        if (number > last)
            counter++

        last = number
    }

    println(counter)
}