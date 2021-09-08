package Assignment3.search

class SearchEx8 {

    // This function, given an array and an integer k, returns an array with the amount
    // of distinct integers in all windows of size k in the array. For example:
    // arr = {1, 2, 1, 3}, k = 3 => {2, 3}
    fun countDistinctIntegersInWindowSizeK (k: Int, array: IntArray) : Array<Int> {
        if (k == 0 || k > array.size) return arrayOf<Int>()

        val helperList = mutableListOf<Int>()
        val countInWindow = HashMap<Int, Int>()

        for (i in 0 until k) {
            countInWindow[array[i]] = (countInWindow[array[i]] ?: 0) + 1
        }

        var left = 0
        var right = k-1
        // We use two pointers for moving the window, and map that counts the occurrences
        // of the integers
        while (right < array.lastIndex) {
            helperList += countInWindow.size

            countInWindow[array[left]] = (countInWindow[array[left]] ?: 1) - 1
            if (countInWindow[array[left]] == 0) countInWindow.remove(array[left])
            left++

            right++
            countInWindow[array[right]] = (countInWindow[array[right]] ?: 0) + 1
        }

        helperList += countInWindow.size

        return helperList.toTypedArray()
    }

}