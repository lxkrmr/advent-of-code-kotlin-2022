import java.io.File

/**
 * Reads text from the given input txt file.
 */
fun readInputAsText(name: String) = File("src", "$name.txt")
        .readText()

/**
 * Reads lines from the given input txt file.
 */
fun readInputAsLines(name: String) = File("src", "$name.txt")
        .readLines()

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
