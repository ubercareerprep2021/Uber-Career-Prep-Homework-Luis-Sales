package Assignment3.sorting

class SortEx4 {

    fun groupAnagrams(array: Array<String>) : Array<Array<String>> {
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

        val returnArray = Array<Array<String>>(returnList.size) {
            returnList[it].toTypedArray()
        }

        return returnArray
    }

}