package Assignment3.sorting

import java.util.*
import kotlin.collections.ArrayList

class SortEx2 {

    /*
    for (i in 0..arr.size) {
            for (j in arr.indices) {
                Arrays.sort(arr, j, min(j + memSize, arr.lastIndex))
            }
        }
    */

    class ArrayMergeHandler constructor(private val ramArray: IntArray, private val fileArray: IntArray) {

        private var rPointer = 0
        private var fPointer = 0

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

    fun getChunkFromTo(array: IntArray, start: Int, end: Int) : IntArray {
        val returnArray = IntArray(end - start)
        var k = start
        for (j in 0 until (end - start)) {
            returnArray[j] = array[k++]
        }
        return returnArray
    }

    fun externalSort(fullArray: IntArray, memSize: Int) : IntArray {
        val chunkCount = if (fullArray.size % memSize == 0) fullArray.size / memSize else (fullArray.size/memSize) + 1
        var outFile = IntArray(0)

        for (i in 0 until chunkCount) {
            val currentChunk = getChunkFromTo(fullArray, i * memSize, (i * memSize) + memSize)
            Arrays.sort(currentChunk)
            outFile = ArrayMergeHandler(currentChunk, outFile).merge()
        }

        return outFile
    }


}

fun testWithRandomArray(arraySize: Int, memorySize: Int) {

    val testArray = IntArray(arraySize)
    val random = Random()

    for (i in 0 until arraySize) {
        testArray[i] = random.nextInt(arraySize)
    }

    val compareArray = testArray.clone()
    compareArray.sort()

    val sort = SortEx2()
    val sortedArray = sort.externalSort(testArray, memorySize)

    for (i in 0 until arraySize) {
        if (sortedArray[i] != compareArray[i]) {
            println("NOT SORTED!")
            return
        }
    }

    println("SORTED!")
}

fun main() {
    testWithRandomArray(10000, 100)
}