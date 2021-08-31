package Assignment3.sorting

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class SortEx1Test {

    private val sort = SortEx1()

    @Test
    fun swap() {

    }

    @Test
    fun threePartitionSort() {
        val testCases = arrayOf(
            intArrayOf(5, 10, 20, 5, 10, 20),
            intArrayOf(20, 5, 20, 20, 5, 10, 20, 20, 5, 10, 20),
            intArrayOf(5, 5, 5, 10, 10, 10, 20, 20, 20),
            intArrayOf(5),
            intArrayOf(10),
            intArrayOf(20),
            intArrayOf(5, 20),
            intArrayOf(10, 5)
        )

        for (testCase in testCases) {
            val expectedValue = testCase.clone()
            expectedValue.sort()
            sort.threePartitionSort(testCase)
            assertArrayEquals(expectedValue, testCase)
        }
    }
}