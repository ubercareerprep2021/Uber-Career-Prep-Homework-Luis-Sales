package Assignment3.search

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SearchEx7Test {

    private val search = SearchEx7()

    @Test
    fun testCheckNumbersThatSumToTargetExist1() {
        val arr = intArrayOf(-2, -1, 0, 4, 6)
        assert(search.arrayContainsNumbersAddingToTarget(3, arr))
    }

    @Test
    fun testCheckNumbersThatSumToTargetExist2() {
        val arr = intArrayOf(-2, -1, 0, 4, 6)
        assert(search.arrayContainsNumbersAddingToTarget(5, arr))
    }

    @Test
    fun testCheckNumbersThatSumToTargetExist3() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        assert(search.arrayContainsNumbersAddingToTarget(3, arr))
    }

    @Test
    fun testCheckNumbersThatSumToTargetExist4() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        assert(!search.arrayContainsNumbersAddingToTarget(10, arr))
    }

    @Test
    fun testCheckNumbersThatSumToTargetExist5() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        assert(!search.arrayContainsNumbersAddingToTarget(1, arr))
    }

    @Test
    fun testCheckNumbersThatSumToTargetExist6() {
        val arr = intArrayOf(1)
        assert(!search.arrayContainsNumbersAddingToTarget(1, arr))
    }

    @Test
    fun testCheckNumbersThatSumToTargetExist7() {
        val arr = intArrayOf()
        assert(!search.arrayContainsNumbersAddingToTarget(0, arr))
    }
}