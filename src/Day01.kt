fun main() {
    fun part1(input: String): Int {
        val bags = input
                .split("\n\n")
                .map { line -> line.split("\n") }
        val summedBags = bags
                .map { bag -> bag.sumOf { string -> string.toIntOrNull() ?: 0 } }
        return summedBags.max()
    }

    fun part2(input: String): Int {
        return input.length
    }

    // test if implementation meets criteria from the description, like:
    val testInputPart1 = readInputAsText("Day01_test")
    check(part1(testInputPart1) == 24_000)

    val input = readInputAsText("Day01")
    part1(input).println()
    part2(input).println()
}
