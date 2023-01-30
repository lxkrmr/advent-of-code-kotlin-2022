fun main() {

    fun part1(input: String): Int {
        val bags = input.toBags()
        val summedBags = bags.sum()
        return summedBags.max()
    }

    fun part2(input: String): Int {
        val bags = input.toBags()
        val summedBags = bags.sum()
        val top3 = summedBags.sorted()
                .reversed()
                .take(3)

        return top3.fold(0) { acc, cur -> acc + cur }
    }

    // test if implementation meets criteria from the description, like:
    val testInputPart1 = readInputAsText("Day01_test")
    check(part1(testInputPart1) == 24_000)

    val testInputPart2 = readInputAsText("Day01_test")
    check(part2(testInputPart2) == 45_000)

    val input = readInputAsText("Day01")
    part1(input).println()
    part2(input).println()
}

internal fun String.toBags() = split("\n\n")
        .map { line -> line.split("\n") }

internal fun List<List<String>>.sum() = map { bag -> bag.sumOf { string -> string.toIntOrNull() ?: 0 } }
