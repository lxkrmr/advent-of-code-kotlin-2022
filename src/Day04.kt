fun main() {

    fun part1(input: List<String>): Int =
        input.count { elvesPair ->
            elvesPair
                .split(",")
                .let { (first, second) ->
                    val firstRange = first.toIntRange()
                    val secondRange = second.toIntRange()
                    firstRange.containsFully(secondRange) || secondRange.containsFully(firstRange)
                }
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

private fun String.toIntRange(): IntRange {
    val intRangeRegex = Regex("""(\d+)-(\d+)""")
    val find = intRangeRegex.find(this)
    val (first, last) = find?.destructured ?: error("Can't convert $this to IntRange")
    return first
        .toInt()
        .rangeTo(last.toInt())
}

private fun IntRange.containsFully(other: IntRange): Boolean =
    this.first <= other.first && this.last >= other.last

