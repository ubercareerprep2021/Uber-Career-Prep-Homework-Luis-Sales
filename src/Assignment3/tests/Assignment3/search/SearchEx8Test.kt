package Assignment3.search

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SearchEx8Test {

    val search = SearchEx8()

    @Test
    fun testCountDistinctIntegersInWindowSizeK_1() {
        val arr = intArrayOf(1, 2, 1, 3, 4, 2, 3)
        val k = 4
        assertArrayEquals(arrayOf<Int>(3, 4, 4, 3), search.countDistinctIntegersInWindowSizeK(k, arr))
    }

    @Test
    fun testCountDistinctIntegersInWindowSizeK_2() {
        val arr = intArrayOf(1, 2, 4, 4)
        val k = 2
        assertArrayEquals(arrayOf<Int>(2, 2, 1), search.countDistinctIntegersInWindowSizeK(k, arr))
    }

    @Test
    fun testCountDistinctIntegersInWindowSizeK_3() {
        val arr = intArrayOf(1, 2, 1)
        val k = 3
        assertArrayEquals(arrayOf<Int>(2), search.countDistinctIntegersInWindowSizeK(k, arr))
    }

    @Test
    fun testCountDistinctIntegersInWindowSizeK_4() {
        val arr = intArrayOf(1)
        val k = 2
        assertArrayEquals(arrayOf<Int>(), search.countDistinctIntegersInWindowSizeK(k, arr))
    }

    @Test
    fun testCountDistinctIntegersInWindowSizeK_5() {
        val arr = intArrayOf(1, 2, 1, 3, 4, 2, 3)
        val k = 0
        assertArrayEquals(arrayOf<Int>(), search.countDistinctIntegersInWindowSizeK(k, arr))
    }

}