fun main() {

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test input
    val testInput = readInputAsLines("Day04_test")
    check(part1(testInput) == 2)
    // check(part2(testInput) == 12)

    // use the given input and print the result
    val input = readInputAsLines("Day04")
    part1(input).println()
    // part2(input).println()
}
