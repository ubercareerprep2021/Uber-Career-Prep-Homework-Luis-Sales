package Assignment3.sorting

class SortEx5 {

    fun swap (array: IntArray, i : Int, j : Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    fun peaksAndValleys(array: IntArray){
        array.sort()

        for (i in 0 until array.lastIndex step 2) {
            swap(array, i, i+1)
        }
    }

}

fun main() {
    val sort = SortEx5()

    val array = intArrayOf(3, 1, 5, 2)
    sort.peaksAndValleys(array)

    println(array.contentToString())
}