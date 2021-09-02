package Assignment3.search

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.ArithmeticException
import kotlin.math.abs

internal class SearchEx3Test {

    val search = SearchEx3()

    @Test
    fun testPow1() {
        assert(search.pow(2.0, 10) == 1024.0)
    }

    @Test
    fun testPow2() {
        assert(search.pow(2.0, -2) == 0.25)
    }

    @Test
    fun testPow3() {
        assert(abs(search.pow(0.2, 3) - 0.008) <= 0.000001)
    }

    @Test
    fun testPow4() {
        assert(search.pow(-3.0, 3) == -27.0)
    }

    @Test
    fun testPow5() {
        assert(search.pow(-3.0, 2) == 9.0)
    }

    @Test
    fun testPow6() {
        assert(search.pow(0.0, 0) == 1.0)
    }

    @Test
    fun testPow7() {
        assert(search.pow(0.0, 3) == 0.0)
    }

    @Test
    fun testPow8() {
        assertThrows(ArithmeticException::class.java) {
            search.pow(0.0, -2)
        }
    }
}