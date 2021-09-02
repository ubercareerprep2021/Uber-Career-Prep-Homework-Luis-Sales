package Assignment3.search

import org.junit.jupiter.api.Test

internal class SearchEx6Test {

    private val search = SearchEx6()

    @Test
    fun testArrayIsSubset1() {
        val arr1 = intArrayOf(1)
        val arr2 = intArrayOf(1)

        assert(search.arrayIsSubset(arr1, arr2))
    }

    @Test
    fun testArrayIsSubset2() {
        val arr1 = intArrayOf(2)
        val arr2 = intArrayOf(1)

        assert(!search.arrayIsSubset(arr1, arr2))
    }

    @Test
    fun testArrayIsSubset3() {
        val arr1 = intArrayOf(1, 2, 3, 4, 5)
        val arr2 = intArrayOf(3, 4)

        assert(search.arrayIsSubset(arr1, arr2))
    }

    @Test
    fun testArrayIsSubset4() {
        val arr1 = intArrayOf(3, 4)
        val arr2 = intArrayOf(1, 2, 3, 4, 5)

        assert(!search.arrayIsSubset(arr1, arr2))
    }

    @Test
    fun testArrayIsSubset5() {
        val arr1 = intArrayOf(1, 2, 3)
        val arr2 = intArrayOf()

        assert(search.arrayIsSubset(arr1, arr2))
    }

    @Test
    fun testArrayIsSubset6() {
        val arr1 = intArrayOf()
        val arr2 = intArrayOf()

        assert(search.arrayIsSubset(arr1, arr2))
    }

    @Test
    fun testArrayIsSubset7() {
        val arr1 = intArrayOf(1)
        val arr2 = intArrayOf(1)

        assert(search.arrayIsSubset(arr1, arr2))
    }
}