fun main() {
    fun findHighestDigit(line: String, pos: Int?): Triple<Int, Int?, Boolean> {
        var highest = -1
        var position = -1
        var left = false
        val searchLine = if (pos == null) {
            line
        } else if (pos < line.length - 2) {
            line.substring(pos + 1)
        } else {
            left = true
            line.dropLast(line.length - pos)
        }
        searchLine.forEachIndexed { curPos, char ->
            val digit = char.digitToInt()
            if (digit > highest) {
                position = curPos
                highest = digit
            }
        }
        return Triple(highest, position, left)
    }

    fun part1(input: List<String>) {
        val reult = input.sumOf { line ->

            val (high, pos, _) = findHighestDigit(line, null)
            val (low, _, left) = findHighestDigit(line, pos)
            if (left) {
                println((low * 10 + high))
                (low * 10 + high)
            } else {
                println((high * 10 + low))
                (high * 10 + low)
            }

        }
        println(reult)
    }


    fun part2(input: List<String>) {
        val result = input.sumOf { line ->
            var battery = ""
            var index = 0
            for (k in 11 downTo 0) {
                var n = 0
                for (i in index..<line.length - k) {
                    val num = line[i].digitToInt()
                    if (n < num) {
                        n = num
                        index = i + 1
                    }
                }
                battery += n.toString()
                println("Battery so far: $battery")
            }
            battery.toLong()
        }
        println(result)
    }

    val input = readInput("Day03")
    //val input = ("987654321111111\n" +
     //      "811111111111119\n" +
     //       "234234234234278\n" +
     //       "818181911112111").lines()
     part1(input)
    part2(input)
}
