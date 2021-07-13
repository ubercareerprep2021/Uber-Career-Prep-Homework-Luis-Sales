package Assignment2.graphs

class GraphEx5 {

    fun canFinishAllCoursesTopSort(numCourses: Int, prerequisites: Array<IntArray>) : Boolean {
        val adjList: MutableMap<Int, MutableList<Int>> = HashMap()
        for (i in 0 until numCourses) {
            adjList[i] = ArrayList()
        }

        val inDegrees = IntArray(numCourses)
        for (course in prerequisites) {
            adjList[course[1]]!!.add(course[0])
            inDegrees[course[0]]++
        }

        val queue = ArrayDeque<Int>()
        for (i in 0 until numCourses) {
            if (inDegrees[i] == 0) queue.add(i)
        }

        var countVisited = 1
        while (!queue.isEmpty()) {
            val currentCourse = queue.removeLastOrNull() ?: continue
            for (neighbor in adjList[currentCourse]!!) {
                inDegrees[neighbor]--
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor)
                    countVisited++
                }
            }
        }

        return countVisited == numCourses
    }

    fun run() {
        val prerequisites = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 1),
            intArrayOf(3, 2),
            intArrayOf(4, 2),
            intArrayOf(5, 4),
            intArrayOf(2, 5)
        )

        println(canFinishAllCoursesTopSort(6, prerequisites))
    }

}

fun main() {
    val ex = GraphEx5()
    ex.run()
}