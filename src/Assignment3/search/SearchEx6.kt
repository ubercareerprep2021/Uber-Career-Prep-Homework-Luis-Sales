package Assignment3.search

class SearchEx6 {

    // This function checks whether arr2 is a subset of arr1 or not. arr1 and arr2 have only distinct integers.
    fun arrayIsSubset(arr1: IntArray, arr2: IntArray) : Boolean {
        if (arr2.isEmpty()) return true // An empty set is a subset of any other set

        val set = HashSet<Int>()
        arr2.forEach {
            set.add(it)
        }

        arr1.forEach {
            if (set.contains(it)) {
                set.remove(it)
            }
        }

        return set.isEmpty()
    }

}