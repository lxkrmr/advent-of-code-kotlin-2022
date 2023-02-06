fun main() {
    fun part1(input: String): String {
        val (stacksAsString, craneInstructionsAsString) = input.split("\n\n")

        val stacks = stacksAsString.toStacks()
        val instructions = craneInstructionsAsString.lines().map(String::toCraneInstruction)

        stacks.println()
        instructions.println()

        return input
    }

    fun part2(input: String): String {
        return input
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsText("Day05_test")
    check(part1(testInput) == "CMZ")
    // check(part2(testInput) == 24000)

    val input = readInputAsText("Day05")
    part1(input).println()
    // part2(input).println()
}

private fun String.toStacks() = this
    .lines()
    .reversed()
    .drop(1)
    .let { stackRows ->
        stackRows.flatMap { stackRow ->
            stackRow.mapIndexedNotNull { index, stackContent ->
                if (index % 4 == 1 && stackContent.isLetter()) {
                    index.toStackIndex() to stackContent
                } else {
                    null
                }
            }
        }
    }.groupBy(
        {(key, _) -> key},
        {(_, value) -> value}
    )

private fun Int.toStackIndex(): Int = if(this % 3 == 0) this / 3 else this / 3 + 1

private fun String.toCraneInstruction(): CraneInstruction =
    """move (\d+) from (\d+) to (\d+)"""
        .toRegex()
        .find(this)
        ?.destructured
        ?.let { (quantity, from, to) ->
            CraneInstruction(quantity, from, to)
        } ?: error("Can't convert $this to CraneInstruction")

private data class CraneInstruction(
    val quantity: Int,
    val from: Int,
    val to: Int,
) {
    constructor(quantity: String, from: String, to: String) : this(quantity.toInt(), from.toInt(), to.toInt())
}
