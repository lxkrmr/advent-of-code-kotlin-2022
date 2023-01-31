fun main() {

    fun part1(input: List<String>): Int {
        // The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors.
        // The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors.
        // Your total score is the sum of your scores for each round.
        // The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
        // plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won)
       return input.size
    }


    fun part2(input: List<String>): Int {
        return input.size
    }

    // test input
    val testInput = readInputAsLines("Day02_test")

    // test part 1: if implementation meets criteria from the description, like:
    check(part1(testInput) == 15)

    // test part 2: if implementation meets criteria from the description, like:
    check(part2(testInput) == 45_000)

    // use the given input and print the result
    val input = readInputAsLines("Day02")
    part1(input).println()
    part2(input).println()
}
