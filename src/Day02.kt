fun main() {

    fun part1(input: List<String>): Int {
        val scores = input.map { round ->
            round.split(" ").let { (pickOpponent, pickPlayer) ->
                val opponent = pickOpponent.toRockPaperScissors()
                val player = pickPlayer.toRockPaperScissors()
                val scoreForSelection = Score(
                    opponent = opponent.toSelectionScore(),
                    player = player.toSelectionScore()
                )
                val scoreForOutcomeOfTheRound = Score(
                    opponent = opponent.vs(player),
                    player = player.vs(opponent)
                )
                scoreForSelection + scoreForOutcomeOfTheRound
            }
        }.fold(Score(
            opponent = 0,
            player = 0
        )) { acc, cur -> acc + cur }

        return scores.player
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test input
    val testInput = readInputAsLines("Day02_test")

    // test part 1: if implementation meets criteria from the description, like:
    check(part1(testInput) == 15)

    // test part 2: if implementation meets criteria from the description, like:
    // check(part2(testInput) == 45_000)

    // use the given input and print the result
    val input = readInputAsLines("Day02")
    part1(input).println()
    part2(input).println()
}

fun String.toRockPaperScissors(): RockPaperScissors = when (this) {
    "A", "X" -> RockPaperScissors.ROCK
    "B", "Y" -> RockPaperScissors.PAPER
    "C", "Z" -> RockPaperScissors.SCISSORS
    else -> error("String $this can't be converted to RockPaperScissors")
}

enum class RockPaperScissors {
    ROCK, PAPER, SCISSORS
}

private fun RockPaperScissors.toSelectionScore(): Int = when (this) {
    RockPaperScissors.ROCK -> 1
    RockPaperScissors.PAPER -> 2
    RockPaperScissors.SCISSORS -> 3
}

private fun RockPaperScissors.vs(other: RockPaperScissors): Int {
    return when {
        this == RockPaperScissors.ROCK && other == RockPaperScissors.ROCK -> 3
        this == RockPaperScissors.ROCK && other == RockPaperScissors.PAPER -> 0
        this == RockPaperScissors.ROCK && other == RockPaperScissors.SCISSORS -> 6
        this == RockPaperScissors.PAPER && other == RockPaperScissors.ROCK -> 6
        this == RockPaperScissors.PAPER && other == RockPaperScissors.PAPER -> 3
        this == RockPaperScissors.PAPER && other == RockPaperScissors.SCISSORS -> 0
        this == RockPaperScissors.SCISSORS && other == RockPaperScissors.ROCK -> 0
        this == RockPaperScissors.SCISSORS && other == RockPaperScissors.PAPER -> 6
        this == RockPaperScissors.SCISSORS && other == RockPaperScissors.SCISSORS -> 3
        else -> error("Invalid combination $this and $other")
    }
}

data class Score(val opponent: Int, val player: Int) {
    operator fun plus(other: Score): Score {
        return Score(
            opponent = this.opponent + other.opponent,
            player = this.player + other.player
        )
    }
}

