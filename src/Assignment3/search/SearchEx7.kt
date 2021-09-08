package Assignment3.search

class SearchEx7 {

    // This function checks whether, given an array and a target integer, there are two numbers in the
    // array that equal target when summed.
    fun arrayContainsNumbersAddingToTarget(target: Int, array: IntArray) : Boolean {
        val complementSet = HashSet<Int>()

        array.forEach {
            val complement = target - it
            if (complementSet.contains(complement)) {
                return true
            } else {
                complementSet.add(it)
            }
        }

        return false
    }



}