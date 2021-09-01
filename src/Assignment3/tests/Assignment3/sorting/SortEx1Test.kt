package Assignment3.sorting

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class SortEx1Test {

    private val sort = SortEx1()

    @Test
    fun testSwapEqualValues() {
        val arr = intArrayOf(0, 0, 1)
        sort.swap(arr, 0, 1)
        assertArrayEquals(intArrayOf(0, 0, 1), arr)
    }

    @Test
    fun testSwapCase1() {
        val arr = intArrayOf(1, 0, 1)
        sort.swap(arr, 0, 1)
        assertArrayEquals(intArrayOf(0, 1, 1), arr)
    }

    @Test
    fun testSwapCase2() {
        val arr = intArrayOf(0, 1, 1)
        sort.swap(arr, 0, 1)
        assertArrayEquals(intArrayOf(1, 0, 1), arr)
    }

    @Test
    fun testSortCase1 () {
        val testCase = intArrayOf(5, 10, 20, 5, 10, 20)
        val expectedValue = testCase.clone()
        expectedValue.sort()
        sort.threePartitionSort(testCase)
        assertArrayEquals(expectedValue, testCase)
    }

    @Test
    fun testSortCase2 () {
        val testCase = intArrayOf(20, 5, 20, 20, 5, 10, 20, 20, 5, 10, 20)
        val expectedValue = testCase.clone()
        expectedValue.sort()
        sort.threePartitionSort(testCase)
        assertArrayEquals(expectedValue, testCase)
    }

    @Test
    fun testSortCase3 () {
        val testCase = intArrayOf(5, 5, 5, 10, 10, 10, 20, 20, 20)
        val expectedValue = testCase.clone()
        expectedValue.sort()
        sort.threePartitionSort(testCase)
        assertArrayEquals(expectedValue, testCase)
    }

    @Test
    fun testSortCase4 () {
        val testCase = intArrayOf(5)
        val expectedValue = testCase.clone()
        expectedValue.sort()
        sort.threePartitionSort(testCase)
        assertArrayEquals(expectedValue, testCase)
    }

    @Test
    fun testSortCase5 () {
        val testCase = intArrayOf(10)
        val expectedValue = testCase.clone()
        expectedValue.sort()
        sort.threePartitionSort(testCase)
        assertArrayEquals(expectedValue, testCase)
    }

    @Test
    fun testSortCase6 () {
        val testCase = intArrayOf(20)
        val expectedValue = testCase.clone()
        expectedValue.sort()
        sort.threePartitionSort(testCase)
        assertArrayEquals(expectedValue, testCase)
    }

    @Test
    fun testSortCase7 () {
        val testCase = intArrayOf(5, 20)
        val expectedValue = testCase.clone()
        expectedValue.sort()
        sort.threePartitionSort(testCase)
        assertArrayEquals(expectedValue, testCase)
    }

    @Test
    fun testSortCase8 () {
        val testCase = intArrayOf(10, 5)
        val expectedValue = testCase.clone()
        expectedValue.sort()
        sort.threePartitionSort(testCase)
        assertArrayEquals(expectedValue, testCase)
    }

    @Test
    fun testSortCase9 () {
        val testCase = intArrayOf()
        val expectedValue = testCase.clone()
        expectedValue.sort()
        sort.threePartitionSort(testCase)
        assertArrayEquals(expectedValue, testCase)
    }
}