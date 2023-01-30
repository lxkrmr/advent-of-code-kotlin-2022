fun main() {
    fun part1(input: List<String>): Int {
        println(input)
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsLines("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInputAsLines("Day01")
    part1(input).println()
    part2(input).println()
}
