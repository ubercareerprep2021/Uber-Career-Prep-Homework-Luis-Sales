package Assignment3.search

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SearchEx5Test {

    val sort = SearchEx5()

    @Test
    fun searchValueInMatrix1() {
        val testArray = arrayOf<Array<Int>>(
            arrayOf<Int>(1,   4,  7, 11, 15),
            arrayOf<Int>(2,   5,  8, 12, 19),
            arrayOf<Int>(3,   6,  9, 16, 22),
            arrayOf<Int>(10, 13, 14, 17, 24),
            arrayOf<Int>(18, 21, 23, 26, 30),
        )

        assert(sort.searchValueInMatrix(testArray, 6))
    }

    @Test
    fun searchValueInMatrix2() {
        val testArray = arrayOf<Array<Int>>(
            arrayOf<Int>(1,   4,  7, 11, 15),
            arrayOf<Int>(2,   5,  8, 12, 19),
            arrayOf<Int>(3,   6,  9, 16, 22),
            arrayOf<Int>(10, 13, 14, 17, 24),
            arrayOf<Int>(18, 21, 23, 26, 30),
        )

        assert(sort.searchValueInMatrix(testArray, 24))
    }

    @Test
    fun searchValueInMatrix3() {
        val testArray = arrayOf<Array<Int>>(
            arrayOf<Int>(1,   4,  7, 11, 15),
            arrayOf<Int>(2,   5,  8, 12, 19),
            arrayOf<Int>(3,   6,  9, 16, 22),
            arrayOf<Int>(10, 13, 14, 17, 24),
            arrayOf<Int>(18, 21, 23, 26, 30),
        )

        assert(sort.searchValueInMatrix(testArray, 18))
    }

    @Test
    fun searchValueInMatrix4() {
        val testArray = arrayOf<Array<Int>>(
            arrayOf<Int>(1,   4,  7, 11, 15),
            arrayOf<Int>(2,   5,  8, 12, 19),
            arrayOf<Int>(3,   6,  9, 16, 22),
            arrayOf<Int>(10, 13, 14, 17, 24),
            arrayOf<Int>(18, 21, 23, 26, 30),
        )

        assert(!sort.searchValueInMatrix(testArray, 0))
    }

    @Test
    fun searchValueInMatrix5() {
        val testArray = arrayOf<Array<Int>>(
            arrayOf<Int>(1,   4,  7, 11, 15),
            arrayOf<Int>(2,   5,  8, 12, 19),
            arrayOf<Int>(3,   6,  9, 16, 22),
            arrayOf<Int>(10, 13, 14, 17, 24),
            arrayOf<Int>(18, 21, 23, 26, 30),
        )

        assert(!sort.searchValueInMatrix(testArray, 25))
    }

    @Test
    fun searchValueInMatrix6() {
        val testArray = arrayOf<Array<Int>>(
            arrayOf<Int>(1, 4, 7),
            arrayOf<Int>(2, 5, 8),
        )

        assert(sort.searchValueInMatrix(testArray, 5))
    }

    @Test
    fun searchValueInMatrix7() {
        val testArray = arrayOf<Array<Int>>(
            arrayOf<Int>(1, 4, 7),
            arrayOf<Int>(2, 5, 8),
        )

        assert(sort.searchValueInMatrix(testArray, 5))
    }

    @Test
    fun searchValueInMatrix8() {
        val testArray = arrayOf<Array<Int>>(
            arrayOf<Int>(1, 4, 7),
            arrayOf<Int>(2, 5, 8),
        )

        assert(!sort.searchValueInMatrix(testArray, 0))
    }

    @Test
    fun searchValueInMatrix9() {
        val testArray = arrayOf<Array<Int>>(

        )

        assert(!sort.searchValueInMatrix(testArray, 0))
    }
}