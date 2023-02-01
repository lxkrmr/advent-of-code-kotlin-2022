fun main() {

    fun part1(input: List<String>): Int =
        input.flatMap { rucksack ->
            val (firstCompartment, secondCompartment) = rucksack.chunked(rucksack.length / 2)
            val common = firstCompartment.filter { item -> item in secondCompartment }.toSet()
            common.map { item -> item.toPriority() }
        }.sum()

    fun part2(input: List<String>): Int =
        input.chunked(3)
                .flatMap { groupOfThree ->
                    val (first, second, third) = groupOfThree
                    val commonBetweenFirstAndSecond = first.filter { item -> item in second }.toSet()
                    val commonBetweenAll = commonBetweenFirstAndSecond.filter { item -> item in third }
                    commonBetweenAll.map { item -> item.toPriority() }
                }.sum()

    // test input
    val testInput = readInputAsLines("Day03_test")

    // test part 1: if implementation meets criteria from the description, like:
    check(part1(testInput) == 157)

    // test part 2: if implementation meets criteria from the description, like:
    check(part2(testInput) == 70)

    // use the given input and print the result
    val input = readInputAsLines("Day03")
    part1(input).println()
    part2(input).println()
}

private fun Char.toPriority(): Int =
    when {
        this.isLowerCase() -> this.code - 96
        this.isUpperCase() -> this.code - 38
        else -> error("Cant convert $this to priority")
    }