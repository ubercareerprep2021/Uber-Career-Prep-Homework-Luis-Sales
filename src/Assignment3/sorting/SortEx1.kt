package Assignment3.sorting

class SortEx1 {

    fun swap(array: IntArray, left: Int, right: Int) {
        val swap = array[left]
        array[left] = array[right]
        array[right] = swap
    }

    // This function takes in an int array. For every i in the array, i may be equal to 5, 10 or 20.
    // The intention of it is to sort in one pass the values of the input array.
    fun threePartitionSort(array: IntArray) {
        var fives = 0 // Pointer to which the next 5 should go to
        var twenties = array.lastIndex // Pointer to which the next 20 should go to
        var current = 0 // Current element of the array we are analyzing

        // We iterate through the array with current. If we find a 5, we swap it with whatever is at fives.
        // Likewise, if we find a 20, we swap it with whatever is at twenties.

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