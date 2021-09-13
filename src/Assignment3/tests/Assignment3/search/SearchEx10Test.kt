package Assignment3.search

import org.junit.jupiter.api.Test

internal class SearchEx10Test {

    val search = SearchEx10()

    private fun buildResultSet(dict: List<String>, arr: Array<Char>): Set<String> {
        val result = search.getValidWords(dict, arr)
        return result.toSet()
    }

    private fun buildExpectedSet(expected : Array<String>) : Set<String> {
        return expected.toSet()
    }

    @Test
    fun testGetValidWords1() {
        val dict = listOf<String>("go","bat","me","eat","goal", "boy", "run")
        val arr = arrayOf<Char>('e','o','b', 'a','m','g', 'l')

        val resultSet = buildResultSet(dict, arr)

        val expectedArr = arrayOf<String>("go", "me", "goal")
        val expectedSet = buildExpectedSet(expectedArr)

        assert(expectedSet == resultSet)
    }

    @Test
    fun testGetValidWords2() {
        val dict = listOf<String>("pizza", "pi")
        val arr = arrayOf<Char>('p')

        val resultSet = buildResultSet(dict, arr)

        val expectedArr = arrayOf<String>()
        val expectedSet = buildExpectedSet(expectedArr)

        assert(expectedSet == resultSet)
    }

    @Test
    fun testGetValidWords3() {
        val dict = listOf<String>("pizza", "pi")
        val arr = arrayOf<Char>('p', 'i', 'z', 'a')

        val resultSet = buildResultSet(dict, arr)

        val expectedArr = arrayOf<String>("pizza", "pi")
        val expectedSet = buildExpectedSet(expectedArr)

        assert(expectedSet == resultSet)
    }

}