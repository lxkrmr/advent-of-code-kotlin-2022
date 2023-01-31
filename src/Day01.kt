fun main() {

    fun part1(input: String): Int {
        val bags = input.toBags()
        val summedBags = bags.deepSum()
        val top1 = summedBags.topNBags(1)
        return top1.sum()
    }

    fun part1Alternative(input: List<String>): Int {
        val summedBags = input.toSummedBags()
        val top1 = summedBags.topNBags(1)
        return top1.sum()
    }

    fun part2(input: String): Int {
        val bags = input.toBags()
        val summedBags = bags.deepSum()
        val top3 = summedBags.topNBags(3)
        return top3.sum()
    }

    fun part2Alternative(input: List<String>): Int {
        val summedBags = input.toSummedBags()
        val top3 = summedBags.topNBags(3)
        return top3.sum()
    }

    // test input
    val testInputPart = readInputAsText("Day01_test")
    val testInputPartAlternative = readInputAsLines("Day01_test")

    // test part 1: if implementation meets criteria from the description, like:
    check(part1(testInputPart) == 24_000)
    // alternative
    check(part1Alternative(testInputPartAlternative) == 24_000)


    // test part 2: if implementation meets criteria from the description, like:
    check(part2(testInputPart) == 45_000)
    // alternative
    check(part2Alternative(testInputPartAlternative) == 45_000)

    // use the given input and print the result
    val input = readInputAsText("Day01")
    val inputAlternative = readInputAsLines("Day01")
    part1(input).println()
    part1Alternative(inputAlternative).println()
    part2(input).println()
    part2Alternative(inputAlternative).println()
}

internal fun String.toBags() = split("\n\n")
        .map { line -> line.lines().map { it.toIntOrNull() ?: 0 } }

internal fun List<List<Int>>.deepSum() = map { bag -> bag.sum() }

fun List<Int>.topNBags(n: Int) = sortedDescending()
        .take(n)

internal fun List<String>.toSummedBags(): List<Int> {
    val result = mutableListOf<Int>()
    var summedBag = 0

    for (line in this) {
        val lineAsInt = line.toIntOrNull()
        if(lineAsInt != null) {
            summedBag += lineAsInt
        } else {
            result.add(summedBag)
            summedBag = 0
        }
    }
    result.add(summedBag)
    return result
}
