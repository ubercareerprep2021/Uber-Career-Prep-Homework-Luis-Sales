package Assignment3.search

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SearchEx9Test {

    private val search = SearchEx9()

    @Test
    fun testCountMatches1() {
        val arr = arrayOf("abba", "abbb", "abbc", "abbd", "abaa", "abca")
        val str = "abbg"
        val k = 3

        assertEquals(4, search.countMatches(arr, str, k))
    }

    @Test
    fun testCountMatches2() {
        val arr = arrayOf("abba", "abbb", "abbc", "abbd", "abaa", "abca")
        val str = "abbg"
        val k = 2

        assertEquals(6, search.countMatches(arr, str, k))
    }

    @Test
    fun testCountMatches3() {
        val arr = arrayOf("abba", "abbb", "abbc", "abbd", "abaa", "abca")
        val str = "abbg"
        val k = 4

        assertEquals(0, search.countMatches(arr, str, k))
    }
}