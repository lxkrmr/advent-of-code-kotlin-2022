fun main() {
    fun part1(input: String): String {
        return input
    }

    fun part2(input: String): String {
        return input
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsText("Day01_test")
    check(part1(testInput) == "CMZ")
    // check(part2(testInput) == 24000)

    val input = readInputAsText("Day01")
    part1(input).println()
    // part2(input).println()
}
