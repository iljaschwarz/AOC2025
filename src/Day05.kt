import kotlin.math.max

fun main() {

    fun parseRanges(input: List<String>): List<Pair<Long, Long>> {
        return input.takeWhile { it.isNotEmpty() }
            .map { line ->
                val (from, to) = line.split("-")
                Pair(from.toLong(), to.toLong())
            }
    }

    fun parseNumbers(input: List<String>): List<Long> {
        return input.dropWhile { it.isNotEmpty() }
            .drop(1)
            .filter { it.isNotEmpty() }
            .map { it.toLong() }
    }

    fun part1(input: List<String>) {
        val ranges = parseRanges(input)
        val numbers = parseNumbers(input)
        val result = numbers.count { num ->
            ranges.any { (from, to) -> num in from..to }
        }
        println(result)
    }

    fun part2(input: List<String>) {
        val ranges = parseRanges(input).sortedBy { it.first }
        var result = 0L
        var current = -1L
        for ((start, end) in ranges) {
            val newStart = max(current + 1, start)
            if (newStart <= end) {
                result += end - newStart + 1
                current = end
            } else {
                current = max(current, end)
            }
        }
        println(result)
    }

    val input = readInput("Day05")
    part1(input)
    part2(input)
}