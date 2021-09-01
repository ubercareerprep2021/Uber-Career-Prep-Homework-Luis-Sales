package Assignment3.sorting

class SortEx5 {

    fun swap (array: IntArray, i : Int, j : Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    // This function takes in an intArray, and organizes it in such a way that for every index i,
    // arr[i-1] <= arr[i] >= arr[i+1] or arr[i-1] >= arr[i] <= arr[i+1].
    fun peaksAndValleys(array: IntArray){
        // By sorting the array, for every index i, we have that arr[i] <= arr[i+1] <= ...
        array.sort()

        // After this, by swapping every even index, we will have that arr[0] >= arr[1] <= arr[2] and so on.
        for (i in 0 until array.lastIndex step 2) {
            swap(array, i, i+1)
        }
    }

}