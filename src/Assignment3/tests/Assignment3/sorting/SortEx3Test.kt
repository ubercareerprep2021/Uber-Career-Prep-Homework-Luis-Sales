package Assignment3.sorting

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class SortEx3Test {

    val sort = SortEx3()

    fun incrementArraySize(a: IntArray, sizeToIncrement: Int) : IntArray {
        val helperArray = ArrayList<Int>()
        for (element in a) {
            helperArray.add(element)
        }
        for (i in 0 until sizeToIncrement) {
            helperArray.add(0)
        }
        return IntArray(helperArray.size) {
            helperArray[it]
        }
    }

    fun mergeArrays(a: IntArray, b: IntArray) : IntArray {
        val c = a + b
        return (a + b).sortedArray()
    }

    @Test
    fun mergeTwoArraysCase1() {
        val aStart = intArrayOf(1, 2, 6, 7, 8)
        val aCopy = aStart.clone()
        val b = intArrayOf(0, 1, 1, 2, 3)

        val a = incrementArraySize(aStart, b.size)

        sort.mergeTwoArrays(a, b)

        val expected = mergeArrays(aCopy, b)
        assertArrayEquals(expected, a)
    }

    @Test
    fun mergeTwoArraysCase2() {
        val aStart = intArrayOf()
        val aCopy = aStart.clone()
        val b = intArrayOf(0, 1, 1, 2, 3)

        val a = incrementArraySize(aStart, b.size)

        sort.mergeTwoArrays(a, b)

        val expected = mergeArrays(aCopy, b)
        assertArrayEquals(expected, a)
    }

    @Test
    fun mergeTwoArraysCase3() {
        val aStart = intArrayOf(1, 2, 6, 7, 8)
        val aCopy = aStart.clone()
        val b = intArrayOf()

        val a = incrementArraySize(aStart, b.size)

        sort.mergeTwoArrays(a, b)

        val expected = mergeArrays(aCopy, b)
        assertArrayEquals(expected, a)
    }
}