fun main() {

    fun part1(input: List<String>): Int {
        // A, X -> rock (1 point)
        // B, Y -> paper (2 points)
        // C, Z -> scissor (3 points)
        // points for outcome of the round:
        // lost -> 0
        // draw -> 3
        // win -> 6
        val allPossibleScenarios = mapOf(
            "A X" to 1 + 3,
            "B X" to 1 + 0,
            "C X" to 1 + 6,
            "A Y" to 2 + 6,
            "B Y" to 2 + 3,
            "C Y" to 2 + 0,
            "A Z" to 3 + 0,
            "B Z" to 3 + 6,
            "C Z" to 3 + 3,
        )
        return input.sumOf { round -> allPossibleScenarios.getOrDefault(round, 0) }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test input
    val testInput = readInputAsLines("Day02_test")
    check(part1(testInput) == 15)
    //check(part2(testInput) == 12)

    // use the given input and print the result
    val input = readInputAsLines("Day02")
    part1(input).println()
    //part2(input).println()
}
