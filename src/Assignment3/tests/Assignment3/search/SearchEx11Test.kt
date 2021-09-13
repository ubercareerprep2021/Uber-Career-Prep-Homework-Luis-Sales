package Assignment3.search

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SearchEx11Test {

    @Test
    fun testAddAndSearch1() {
        val test = SearchEx11.Trie()

        test.addWord("bad")
        test.addWord("dad")
        test.addWord("mad")

        assertEquals(false, test.search("pad"))
        assertEquals(true, test.search("bad"))
        assertEquals(true, test.search(".ad"))
        assertEquals(true, test.search("..d"))
        assertEquals(false, test.search("...."))
        assertEquals(false, test.search("c.."))

        test.addWord("cane")
        assertEquals(true, test.search("...."))
        assertEquals(false, test.search(".b.."))
        assertEquals(false, test.search(".."))
        assertEquals(false, test.search(""))
    }

}