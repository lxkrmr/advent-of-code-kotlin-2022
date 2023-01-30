fun main() {

    fun part1(input: String): Int {
        val bags = input.toBags()
        val summedBags = bags.deepSum()
        val top1 = summedBags.topNBags(1)
        return top1.sum()
    }

    fun part2(input: String): Int {
        val bags = input.toBags()
        val summedBags = bags.deepSum()
        val top3 = summedBags.topNBags(3)
        return top3.sum()
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
        .map { line -> line.lines().map { it.toIntOrNull() ?: 0 } }

internal fun List<List<Int>>.deepSum() = map { bag -> bag.sum() }

fun List<Int>.topNBags(n: Int) = sortedDescending()
        .take(n)
