fun main() {
    fun part1(input: List<String>): Int {
        return input
            .toTotalCalories()
            .max()
    }

    fun part2(input: List<String>): Int {
        return input
            .toTotalCalories()
            .sortedDescending()
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsLines("Day01_test")
    check(part1(testInput).also { println(it) } == 24_000)
    check(part2(testInput).also { println(it) } == 45_000)

    val input = readInputAsLines("Day01")
    part1(input).println()
    part2(input).println()
}

internal fun List<String>.toTotalCalories(): List<Int> {
    val result = mutableListOf<Int>()
    var totalCalories = 0

    for (line in this) {
        when (val caloriesOrNull = line.toIntOrNull()) {
            null -> {
                result.add(totalCalories)
                totalCalories = 0
            }

            else -> {
                totalCalories += caloriesOrNull
            }
        }
    }

    result.add(totalCalories)
    return result.toList()
}
