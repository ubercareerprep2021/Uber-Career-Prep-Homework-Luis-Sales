package Assignment3.sorting

import java.util.*
import kotlin.collections.ArrayList

class SortEx2 {

    // This class executes the Merge part of the MergeSort algorithm. Given a ramArray (the integers in RAM),
    // and fileArray (the integers stored in the hard disk), it merges both arrays.
    class ArrayMergeHandler constructor(private val ramArray: IntArray, private val fileArray: IntArray) {

        private var rPointer = 0 // Pointer to the current position in ramArray
        private var fPointer = 0 // Pointer to the current position in fileArray

        private fun nextInRam() : Int{
            return ramArray[rPointer++]
        }

        private fun nextInFile() : Int {
            return fileArray[fPointer++]
        }

        private fun minimumValue() : Int {
            return if (ramArray[rPointer] < fileArray[fPointer]) {
                nextInRam()
            } else {
                nextInFile()
            }
        }

        // Standard merge algorithm
        fun merge() : IntArray {
            val helperList = ArrayList<Int>()
            while (rPointer < ramArray.size && fPointer < fileArray.size)
                helperList.add(minimumValue())

            while (rPointer < ramArray.size)
                helperList.add(nextInRam())
            while (fPointer < fileArray.size)
                helperList.add(nextInFile())

            val returnFile = IntArray(helperList.size)
            for (i in returnFile.indices) {
                returnFile[i] = helperList[i]
            }

            return returnFile
        }

    }

    // This function simulates an external mergesort algorithm. It takes in fullArray, that is the array
    // to be sorted (and can be considered to be a file), and memSize, the maximum amount of elements we can have
    // in the RAM at any given moment.
    fun externalSort(fullArray: IntArray, memSize: Int = 100) : IntArray {

        // chunkCount is the amount of ranges of size memSize that we can have in fullArray
        val chunkCount = if (fullArray.size % memSize == 0) fullArray.size / memSize else (fullArray.size/memSize) + 1

        // outFile is considered to be the external file to which we are storing the sorted fullArray
        var outFile = IntArray(0)

        for (i in 0 until chunkCount) {
            val currentChunk = fullArray.copyOfRange(i * memSize, (i * memSize) + memSize)
            Arrays.sort(currentChunk)
            outFile = ArrayMergeHandler(currentChunk, outFile).merge()
        }

        return outFile
    }


}