fun main() {

    fun countNeighbours(input: List<String>, x: Int, y: Int): Int {

        var count = 0
        // UP
        if (x > 0) {
            if (input[x - 1][y] == '@') {
                count++
            }
        }
        // DOWN
        if (x < input.size - 1) {
            if (input[x + 1][y] == '@') {
                count++
            }
        }
        // LEFT
        if (y > 0) {
            if (input[x][y - 1] == '@') {
                count++
            }
        }
        // RIGHT
        if (y < input[x].length - 1) {
            if (input[x][y + 1] == '@') {
                count++
            }
        }
        // UP-LEFT
        if (x > 0 && y > 0) {
            if (input[x - 1][y - 1] == '@') {
                count++
            }
        }
        // UP-RIGHT
        if (x > 0 && y < input[x].length - 1) {
            if (input[x - 1][y + 1] == '@') {
                count++
            }
        }
        // DOWN-LEFT
        if (x < input.size - 1 && y > 0) {
            if (input[x + 1][y - 1] == '@') {
                count++
            }
        }
        // DOWN-RIGHT
        if (x < input.size - 1 && y < input[x].length - 1) {
            if (input[x + 1][y + 1] == '@') {
                count++
            }
        }
        return count
    }

    fun part1(input: List<String>) {
        var result = 0
        for (x in 0..<input.size) {
            for (y in 0..<input[x].length) {
                if (input[x][y]=='@' && countNeighbours(input, x, y) < 4) {
                    result++
                }
            }
        }
        println(result)
    }

    fun part2(input: MutableList<String>) {
        var result = 0
        val removable : MutableList<Pair<Int,Int>> = mutableListOf()
        do {
            removable.clear()
            for (x in 0..<input.size) {
                for (y in 0..<input[x].length) {
                    if (input[x][y]=='@' && countNeighbours(input, x, y) < 4) {
                        result++
                        removable.add(Pair(x,y))
                    }
                }
            }
            removable.forEach {
                fun String.replaceCharAt(index: Int, newChar: Char): String {
                    return this.substring(0, index) + newChar + this.substring(index + 1)
                }
                input[it.first] = input[it.first].replaceCharAt(it.second, '.')
            }
        } while (removable.isNotEmpty())
        println(result)
    }
    val input = readInput("Day04")
//    val input = ("..@@.@@@@.\n" +
//            "@@@.@.@.@@\n" +
//            "@@@@@.@.@@\n" +
//            "@.@@@@..@.\n" +
//            "@@.@@@@.@@\n" +
//            ".@@@@@@@.@\n" +
//            ".@.@.@.@@@\n" +
//            "@.@@@.@@@@\n" +
//            ".@@@@@@@@.\n" +
//            "@.@.@@@.@.").lines()
    part1(input)
    part2(input as MutableList)
}
