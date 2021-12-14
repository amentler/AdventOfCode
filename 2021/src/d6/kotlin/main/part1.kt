package d6p1

fun main() {
    val fileContent = object {}.javaClass.getResource("/inputd6")?.readText() as String

    val lines = transformInput(fileContent)
    println(part1(lines))
}

fun transformInput(fileContent: String): Swarm {
    val swarm = Swarm()
    fileContent.split(",").map { it.trim() }.map(String::toInt)
        .forEach { swarm.addFish(Lanternfish(it, swarm::addFish)) }
    swarm.endDay()
    return swarm
}

fun part1(swarm: Swarm): Int {
    for (day in 0 until 80) {
        swarm.swarm.forEach {
            it.nextDay()
        }
        swarm.endDay()
    }

    return swarm.swarm.size
}

class Swarm(){
    var swarm = mutableListOf<Lanternfish>()
    var newFishes = mutableListOf<Lanternfish>()

    fun addFish(fish: Lanternfish) {
        newFishes.add(fish)
    }

    fun endDay() {
        swarm.addAll(newFishes)
        newFishes = mutableListOf<Lanternfish>()
    }
}


class Lanternfish(
    private var reproductionDays: Int,
    private var addFish: (Lanternfish) -> Unit
) {
    constructor(addFish: (Lanternfish) -> Unit) : this(8, addFish) {}

    fun nextDay() {
        if (reproductionDays == 0) {
            addFish(Lanternfish(addFish))
            reproductionDays = 7
        }

        this.reproductionDays -= 1
    }
}