package Assignment3.search

import org.junit.jupiter.api.Test

import java.lang.Integer.min

internal class SearchEx1Test {

    val search = SearchEx1()

    fun getMinimum(arr: IntArray) : Int {
        var result = Int.MAX_VALUE
        for (i in arr) {
            result = min(result, i)
        }
        return result
    }

    @Test
    fun testFindSorted1() {
        val testCase = intArrayOf(4, 5, 1, 2, 3)
        assert(search.findMinimumInRotatedSortedArray(testCase) == getMinimum(testCase))
    }

    @Test
    fun testFindSorted2() {
        val testCase = intArrayOf(4, 5, 6, -1, 0, 1, 2, 3)
        assert(search.findMinimumInRotatedSortedArray(testCase) == getMinimum(testCase))
    }

    @Test
    fun testFindSorted3() {
        val testCase = intArrayOf(1, 2, 3, 4, 5)
        assert(search.findMinimumInRotatedSortedArray(testCase) == getMinimum(testCase))
    }

    @Test
    fun testFindSorted4() {
        val testCase = intArrayOf(5, 4)
        assert(search.findMinimumInRotatedSortedArray(testCase) == getMinimum(testCase))
    }

    @Test
    fun testFindSorted5() {
        val testCase = intArrayOf()
        assert(search.findMinimumInRotatedSortedArray(testCase) == getMinimum(testCase))
    }

    @Test
    fun testFindSorted6() {
        val testCase = intArrayOf(4, 5, -1, 0, 1, 2, 3)
        assert(search.findMinimumInRotatedSortedArray(testCase) == getMinimum(testCase))
    }

    @Test
    fun testFindSorted7() {
        val testCase = intArrayOf(4, -1, 0, 1, 2)
        assert(search.findMinimumInRotatedSortedArray(testCase) == getMinimum(testCase))
    }

    @Test
    fun testFindSorted8() {
        val testCase = intArrayOf(4, 5, 6, 0, 1)
        assert(search.findMinimumInRotatedSortedArray(testCase) == getMinimum(testCase))
    }
}