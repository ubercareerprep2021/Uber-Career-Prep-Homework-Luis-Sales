package Assignment3.sorting

import org.junit.jupiter.api.Test

internal class SortEx5Test {

    private val sort = SortEx5()

    private fun arrayHasBeenSorted(arr: IntArray) : Boolean {
        for (i in 1 until arr.lastIndex) {
            if (!((arr[i-1] >= arr[i] && arr[i] <= arr[i+1]) ||
                (arr[i-1] <= arr[i] && arr[i] >= arr[i+1]))
            ) {
                return false
            }
        }
        return true
    }

    @Test
    fun testPeaksAndValleys1() {
        val array = intArrayOf(3, 1, 5, 2)
        sort.peaksAndValleys(array)

        assert(arrayHasBeenSorted(array))
    }

    @Test
    fun testPeaksAndValleys2() {
        val array = intArrayOf(3, 1, 20, 5, 4, 3, 2, 2, 1, 6, 2)
        sort.peaksAndValleys(array)

        assert(arrayHasBeenSorted(array))
    }

    @Test
    fun testPeaksAndValleys3() {
        val array = intArrayOf(3, 2)
        sort.peaksAndValleys(array)

        assert(arrayHasBeenSorted(array))
    }
}