package Assignment3.search

class SearchEx5 {

    fun searchValueInMatrix(matrix: Array<Array<Int>>, target: Int) : Boolean {
        var currentRow = 0
        var currentCol = matrix.lastIndex

        while (currentRow < matrix.size && currentCol >= 0) {
            if (matrix[currentRow][currentCol] == target) return true
            if (matrix[currentRow][currentCol] > target) {
                currentCol--
            } else {
                currentRow++
            }
        }
        return false
    }

}