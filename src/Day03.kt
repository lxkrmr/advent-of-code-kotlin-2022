fun main() {

    fun part1(input: List<String>): Int {
        input.println()
        return input.size
    }

    fun part2(input: List<String>): Int {
       return input.size
    }

    // test input
    val testInput = readInputAsLines("Day03_test")

    // test part 1: if implementation meets criteria from the description, like:
    check(part1(testInput) == 157)

    // test part 2: if implementation meets criteria from the description, like:
    check(part2(testInput) == 12)

    // use the given input and print the result
    val input = readInputAsLines("Day03")
    part1(input).println()
    part2(input).println()
}