package Assignment3.sorting

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class SortEx2Test {

    val sort = SortEx2()

    @Test
    fun testGetFullArray() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(1, 2, 3, 4, 5)
        val result = array.copyOfRange(0, 5)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testGetArrayOutOfBounds1() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        assertThrows(IndexOutOfBoundsException::class.java) {
            array.copyOfRange(0, 7)
        }
    }

    @Test
    fun testGetArrayOutOfBounds2() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        assertThrows(IndexOutOfBoundsException::class.java) {
            array.copyOfRange(10, 7)
        }
    }

    @Test
    fun testGetSingleElementArray() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(2)
        val result = array.copyOfRange(1, 2)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testSortRandomArray() {
        val arraySize = 100_000
        val memSize = 100
        val testArray = IntArray(arraySize)
        val random = Random()

        for (i in 0 until arraySize) {
            testArray[i] = random.nextInt(arraySize)
        }

        val compareArray = testArray.clone()
        compareArray.sort()

        val sort = SortEx2()
        val sortedArray = sort.externalSort(testArray, memSize)

        assertArrayEquals(sortedArray, compareArray)

    }
}