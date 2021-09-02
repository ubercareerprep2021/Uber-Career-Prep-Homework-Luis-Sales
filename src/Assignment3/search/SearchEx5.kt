package Assignment3.search

class SearchEx5 {

    // This function searches for a value in a 2D matrix that is sorted (both row-wise, and column-wise)
    // in O(n+m), with n being the height, and m being the width of the matrix.
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