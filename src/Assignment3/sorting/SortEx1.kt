package Assignment3.sorting

class SortEx1 {

    fun swap(array: IntArray, left: Int, right: Int) {
        val swap = array[left]
        array[left] = array[right]
        array[right] = swap
    }

    fun threePartitionSort(array: IntArray) {
        var fives = 0
        var twenties = array.lastIndex
        var current = 0

        while (fives < twenties && current <= twenties) {
            if (array[current] == 5) {
                swap(array, fives++, current++)
            } else if (array[current] == 20) {
                swap(array, current, twenties--)
            } else {
                current++
            }
        }
    }

}

fun main() {
    val testArray = intArrayOf(5, 10, 5, 20, 5, 5, 10)

    val sort = SortEx1()
    sort.threePartitionSort(testArray)
    println(testArray.contentToString())
}