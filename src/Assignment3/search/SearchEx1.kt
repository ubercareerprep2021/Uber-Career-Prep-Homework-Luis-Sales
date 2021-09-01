package Assignment3.search

import kotlin.math.min

class SearchEx1 {

    // This function takes in a integer array that is sorted, but also rotated.
    // An example of such an array would be [4, 5, 6, 1, 2, 3], which has been rotated 3 times.
    // Its output is the minimum value in said array. It operates in O(log(n))
    fun findMinimumInRotatedSortedArray(arr: IntArray) : Int {
        var start = 0
        var end = arr.lastIndex
        var minimumCandidate = Int.MAX_VALUE

        while (start < end) {
            val mid = (start + end)/2
            minimumCandidate = min(arr[start], min(arr[end], arr[mid]))
            if (arr[mid] >= arr[end]) {
                start = mid+1
            } else {
                end = mid
            }
        }

        return minimumCandidate
    }

}