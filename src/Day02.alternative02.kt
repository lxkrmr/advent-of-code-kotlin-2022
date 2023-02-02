fun main() {

    fun part1(input: List<String>): Int =
        input.sumOf { round ->
            val (opponent, player) = round.split(" ").let { (pickOpponent, pickPlayer) ->
                pickOpponent.toSymbol() to pickPlayer.toSymbol()
            }
            player.points + (player vs opponent).points
        }

    fun part2(input: List<String>): Int =
        input.sumOf { round ->
            round.split(" ").let { (pickOpponent, expectedResult) ->
                val opponent = pickOpponent.toSymbol()
                val player: Symbol = expectedResult.toOutcome().toSymbol(opponent)
                player.points + (player vs opponent).points
            }
        }

    // test input
    val testInput = readInputAsLines("Day02_test")
    check(part1(testInput).also { println(it) } == 15)
    check(part2(testInput).also { println(it) } == 12)

    // use the given input and print the result
    val input = readInputAsLines("Day02")
    part1(input).println()
    part2(input).println()
}

private enum class Symbol(val points: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    fun beats(): Symbol =
        when (this) {
            ROCK -> SCISSORS
            PAPER -> ROCK
            SCISSORS -> PAPER
        }

    fun beatenBy(): Symbol =
        when (this) {
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
        }
}

private enum class Outcome(val points: Int) {
    LOSE(0),
    DRAW(3),
    WIN(6);

    fun toSymbol(opponent: Symbol): Symbol =
        when (this) {
            LOSE -> opponent.beats()
            DRAW -> opponent
            WIN -> opponent.beatenBy()
        }
}

private fun String.toSymbol(): Symbol = when (this) {
    "A", "X" -> Symbol.ROCK
    "B", "Y" -> Symbol.PAPER
    "C", "Z" -> Symbol.SCISSORS
    else -> error("Can't convert $this to Symbol")
}

private infix fun Symbol.vs(other: Symbol): Outcome =
    when (other) {
        this.beats() -> Outcome.WIN
        this.beatenBy() -> Outcome.LOSE
        else -> Outcome.DRAW
    }

private fun String.toOutcome(): Outcome =
    when (this) {
        "X" -> Outcome.LOSE
        "Y" -> Outcome.DRAW
        "Z" -> Outcome.WIN
        else -> error("Can't convert $this to Outcome")
    }
