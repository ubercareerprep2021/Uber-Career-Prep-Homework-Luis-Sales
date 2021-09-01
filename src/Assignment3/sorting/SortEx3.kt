package Assignment3.sorting

import java.util.*

class SortEx3 {

    // This function merges two sorted intArrays. If array 'a' has n elements to be sorted,
    // and 'b' has m elements to be sorted, then len(a) = n + m, in such a way that the function
    // merges 'a' and 'b' into a, while using constant space.
    // It does so by merging a and b right-to-left.
    fun mergeTwoArrays(a: IntArray, b: IntArray) {
        var nextNumberPointer = a.lastIndex // Points to the next position in a in which we should put the next element
        var aPointer = a.size - b.size - 1
        var bPointer = b.lastIndex

        while (aPointer >= 0 && bPointer >= 0) {
            if (a[aPointer] > b[bPointer]) {
                a[nextNumberPointer--] = a[aPointer--]
            } else {
                a[nextNumberPointer--] = b[bPointer--]
            }
        }

        while (aPointer >= 0) {
            a[nextNumberPointer--] = a[aPointer--]
        }
        while (bPointer >= 0) {
            a[nextNumberPointer--] = b[bPointer--]
        }
    }

}