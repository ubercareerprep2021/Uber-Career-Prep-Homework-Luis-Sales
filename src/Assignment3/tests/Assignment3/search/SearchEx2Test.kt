package Assignment3.search

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SearchEx2Test {

    val search = SearchEx2()

    @Test
    fun testFindElementIndexInRotatedSortedArray1() {
        val testCase = intArrayOf(4, 5, 1, 2, 3)
        assert(search.findElementIndexInRotatedSortedArray(testCase, 2) == 3)
    }

    @Test
    fun testFindElementIndexInRotatedSortedArray2() {
        val testCase = intArrayOf(4, 5, 6, -1, 0, 1, 2, 3)
        assert(search.findElementIndexInRotatedSortedArray(testCase, 4) == 0)
    }

    @Test
    fun testFindElementIndexInRotatedSortedArray3() {
        val testCase = intArrayOf(1, 2, 3, 4, 5)
        assert(search.findElementIndexInRotatedSortedArray(testCase, 5) == 4)
    }

    @Test
    fun testFindElementIndexInRotatedSortedArray4() {
        val testCase = intArrayOf(5, 4)
        assert(search.findElementIndexInRotatedSortedArray(testCase, 5) == 0)
    }

    @Test
    fun testFindElementIndexInRotatedSortedArray5() {
        val testCase = intArrayOf()
        assert(search.findElementIndexInRotatedSortedArray(testCase, 2) == -1)
    }

    @Test
    fun testFindElementIndexInRotatedSortedArray6() {
        val testCase = intArrayOf(4, 5, -1, 0, 1, 2, 3)
        assert(search.findElementIndexInRotatedSortedArray(testCase, 10) == -1)
    }

    @Test
    fun testFindElementIndexInRotatedSortedArray7() {
        val testCase = intArrayOf(4,5,6,7,8,1,2,3)
        assert(search.findElementIndexInRotatedSortedArray(testCase, 8) == 4)
    }

    @Test
    fun testFindElementIndexInRotatedSortedArray8() {
        val testCase = intArrayOf(3,1)
        assert(search.findElementIndexInRotatedSortedArray(testCase, 1) == 1)
    }
}