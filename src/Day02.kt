fun main() {
    fun part1(input: List<String>) =
        input[0].split(",")
            .flatMap { it.split("-").let { (from, to) -> from.toLong()..to.toLong() } }
            .filter { n -> n.toString().let { s -> s.take(s.length / 2) == s.substring(s.length / 2) } }
            .sum()
            .also(::println)

    fun checkRepeating(num: Long): Boolean {
        val s = num.toString()
        return (1..s.length / 2).any { length ->
            val seq = s.take(length)
            s.chunked(length).all { it == seq }
        }
    }

    fun part2(input: List<String>) =
        input[0].split(",")
            .flatMap { it.split("-").let { (from, to) -> from.toLong()..to.toLong() } }
            .filter(::checkRepeating)
            .sum()
            .also(::println)

    val input = readInput("Day02")
    //val input =
//    listOf("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")

    part1(input)
    part2(input)
}
