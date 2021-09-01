package Assignment3.sorting

import org.junit.jupiter.api.Test

internal class SortEx4Test {

    private val sort = SortEx4()

    private fun buildSetEntryFromArray(arr: Array<String>) : String {
        val sorted = arr.sortedArray()
        var string = ""
        for (str in sorted) {
            string += " | $str"
        }
        return string
    }

    private fun getMapFromArray(array: Array<Array<String>>) : HashSet<String>{
        val set = HashSet<String>()
        for (subarray in array) {
            set.add(buildSetEntryFromArray(subarray))
        }
        return set
    }

    @Test
    fun testGroupAnagrams1() {
        val inputArray = arrayOf<String>("eat","tea","tan","ate","nat","bat")
        val expectedArray = arrayOf<Array<String>>(
            arrayOf<String>("bat"),
            arrayOf<String>("nat", "tan"),
            arrayOf<String>("ate","eat","tea"),
        )

        val resultArray = sort.groupAnagrams(inputArray)

        val expectedSet = getMapFromArray(expectedArray)
        val resultSet = getMapFromArray(resultArray)

        assert(expectedSet.size == resultSet.size)
        for (s in expectedSet) {
            assert(resultSet.contains(s))
        }
    }

    @Test
    fun testGroupAnagrams2() {
        val inputArray = arrayOf<String>("eat","tea")
        val expectedArray = arrayOf<Array<String>>(
            arrayOf<String>("eat","tea"),
        )

        val resultArray = sort.groupAnagrams(inputArray)

        val expectedSet = getMapFromArray(expectedArray)
        val resultSet = getMapFromArray(resultArray)

        assert(expectedSet.size == resultSet.size)
        for (s in expectedSet) {
            assert(resultSet.contains(s))
        }
    }

    @Test
    fun testGroupAnagrams3() {
        val inputArray = arrayOf<String>()
        val expectedArray = arrayOf<Array<String>>(
        )

        val resultArray = sort.groupAnagrams(inputArray)

        val expectedSet = getMapFromArray(expectedArray)
        val resultSet = getMapFromArray(resultArray)

        assert(expectedSet.size == resultSet.size)
        for (s in expectedSet) {
            assert(resultSet.contains(s))
        }
    }


}