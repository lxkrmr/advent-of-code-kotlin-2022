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
        }.fold(
            Score(
                opponent = 0,
                player = 0
            )
        ) { acc, cur -> acc + cur }

        return scores.player
    }

    fun part2(input: List<String>): Int {
        val scores = input.map { round ->
            round.split(" ").let { (pickOpponent, expectedEndResult) ->
                val opponent = pickOpponent.toRockPaperScissors()
                val roundNeedsToEnd = expectedEndResult.toRoundNeedsToEnd()
                val player = roundNeedsToEnd.pickRockPaperScissors(opponent)
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
        }.fold(
            Score(
                opponent = 0,
                player = 0
            )
        ) { acc, cur -> acc + cur }

        scores.println()
        return scores.player
    }

    // test input
    val testInput = readInputAsLines("Day02_test")

    // test part 1: if implementation meets criteria from the description, like:
    check(part1(testInput) == 15)

    // test part 2: if implementation meets criteria from the description, like:
    check(part2(testInput) == 12)

    // use the given input and print the result
    val input = readInputAsLines("Day02")
    part1(input).println()
    part2(input).println()
}

private fun RoundNeedsToEnd.pickRockPaperScissors(opponent: RockPaperScissors): RockPaperScissors = when (this) {
    RoundNeedsToEnd.LOSE -> {
        when (opponent) {
            RockPaperScissors.ROCK -> RockPaperScissors.SCISSORS
            RockPaperScissors.PAPER -> RockPaperScissors.ROCK
            RockPaperScissors.SCISSORS -> RockPaperScissors.PAPER
        }
    }

    RoundNeedsToEnd.WIN -> {
        when (opponent) {
            RockPaperScissors.ROCK -> RockPaperScissors.PAPER
            RockPaperScissors.PAPER -> RockPaperScissors.SCISSORS
            RockPaperScissors.SCISSORS -> RockPaperScissors.ROCK
        }
    }

    RoundNeedsToEnd.DRAW -> opponent
}

fun String.toRockPaperScissors(): RockPaperScissors = when (this) {
    "A", "X" -> RockPaperScissors.ROCK
    "B", "Y" -> RockPaperScissors.PAPER
    "C", "Z" -> RockPaperScissors.SCISSORS
    else -> error("String $this can't be converted to RockPaperScissors")
}

fun String.toRoundNeedsToEnd(): RoundNeedsToEnd = when (this) {
    "X" -> RoundNeedsToEnd.LOSE
    "Y" -> RoundNeedsToEnd.DRAW
    "Z" -> RoundNeedsToEnd.WIN
    else -> error("String $this can't be converted to RoundNeedsToEnd")
}

enum class RockPaperScissors {
    ROCK, PAPER, SCISSORS
}

enum class RoundNeedsToEnd {
    LOSE, WIN, DRAW
}

private fun RockPaperScissors.toSelectionScore(): Int = when (this) {
    RockPaperScissors.ROCK -> 1
    RockPaperScissors.PAPER -> 2
    RockPaperScissors.SCISSORS -> 3
}

private fun RockPaperScissors.vs(opponent: RockPaperScissors): Int = when (this) {
    RockPaperScissors.ROCK -> {
        when (opponent) {
            RockPaperScissors.ROCK -> 3
            RockPaperScissors.PAPER -> 0
            RockPaperScissors.SCISSORS -> 6
        }
    }

    RockPaperScissors.PAPER -> {
        when (opponent) {
            RockPaperScissors.ROCK -> 6
            RockPaperScissors.PAPER -> 3
            RockPaperScissors.SCISSORS -> 0
        }
    }

    RockPaperScissors.SCISSORS -> {
        when (opponent) {
            RockPaperScissors.ROCK -> 0
            RockPaperScissors.PAPER -> 6
            RockPaperScissors.SCISSORS -> 3
        }
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

