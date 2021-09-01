package Assignment3.search

class SearchEx2 {

    // This function takes in a integer array that is sorted, but also rotated.
    // An example of such an array would be [4, 5, 6, 1, 2, 3], which has been rotated 3 times.
    // Its output is the index of numberToFind, or -1 if numberToFind is not in the array
    fun findElementIndexInRotatedSortedArray(array: IntArray, numberToFind: Int) : Int {
        if (array.isEmpty()) return -1

        var start = 0
        var end = array.lastIndex

        while (start < end) {
            val mid = (start + end)/2
            if (array[mid] == numberToFind) return mid
            if (array[start] == numberToFind) return start
            if (array[end] == numberToFind) return end
            if (start == end) {
                return if (array[start] == numberToFind) start else -1
            }
            // If we have a valid range from start to mid
            if (array[start] < array[mid]) {
                // If numberToFind is between start and mid
                if (array[start] <= numberToFind && numberToFind < array[mid]) {
                    end = mid-1
                } else {
                    start = mid+1
                }
            } else {
                // If numberToFind is between mid and end
                if (array[mid] < numberToFind && numberToFind <= array[end]) {
                    start = mid+1
                } else {
                    end = mid-1
                }
            }
        }

        return if (numberToFind == array[start]) start
        else -1
    }

}