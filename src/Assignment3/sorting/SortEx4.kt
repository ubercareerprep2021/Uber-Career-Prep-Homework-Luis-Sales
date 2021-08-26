package Assignment3.sorting

class SortEx4 {

    fun groupAnagrams(array: Array<String>) : List<List<String>> {
        val anagramToEquivalentsMap = HashMap<String, MutableList<String>>()

        for (string in array) {
            val sorted = string.toCharArray().sorted().joinToString()
            if (!anagramToEquivalentsMap.contains(sorted)) {
                anagramToEquivalentsMap[sorted] = ArrayList()
            }
            anagramToEquivalentsMap[sorted]!!.add(string)
        }

        val returnList = mutableListOf<List<String>>()
        anagramToEquivalentsMap.forEach {
            returnList.add(it.value)
        }

        return returnList
    }

}

fun main() {

}