
import kotlin.math.abs


fun main() {

    val input = readInput("Day01")
    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    var pos = 50
    var count = 0
    for (line in input) {
        val amount = if (line.startsWith("L", false)) {
            line.substring(1).toInt() * -1
        } else {
            line.substring(1).toInt()
        }

        pos = mod100(pos + amount)

        if (pos == 0) {
            count++
        }
    }

    println(count)
}

fun part2(input: List<String>) {
    var pos = 50
    var count = 0

    for (line in input) {
        val amount = if (line.startsWith("L", false)) {
            line.substring(1).toInt() * -1
        } else {
            line.substring(1).toInt()
        }
        count += abs((pos + amount) / 100)
        if (amount < 0 && pos != 0 && pos + amount <= 0)
            count++

        pos = mod100(pos + amount)

    }
    println(count)
}

fun mod100(num: Int): Int {
    return (num % 100 + 100) % 100
}