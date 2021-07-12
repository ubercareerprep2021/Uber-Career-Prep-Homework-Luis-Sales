package Assignment2.graphs

class GraphEx4 {

    fun getMinimumEdges(u: GraphNode, v: GraphNode, graph: GraphEx1.Graph) : Int {
        val queue = ArrayDeque<GraphNode>()
        val visited = HashSet<GraphNode>()
        queue.add(u)
        visited.add(u)
        var count = 0

        while (!queue.isEmpty()) {
            val n = queue.size
            count++
            for (i in 0..n) {
                val currentNode = queue.removeLastOrNull() ?: continue
                if (currentNode == v) return count
                for (neighbor in graph.adjNodes[currentNode]!!) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor)
                        visited.add(neighbor)
                    }
                }
            }
        }

        return count
    }

    fun main() {

        val graph = GraphEx1.Graph()

        graph.addNode(0)
        graph.addNode(1)
        graph.addNode(2)
        graph.addNode(3)
        graph.addNode(4)
        graph.addNode(5)
        graph.addNode(6)

        graph.addEdge(0, 1)
        graph.addEdge(0, 2)
        graph.addEdge(0, 4)
        graph.addEdge(1, 2)
        graph.addEdge(2, 5)
        graph.addEdge(3, 4)
        graph.addEdge(4, 5)
        graph.addEdge(4, 6)

        println(getMinimumEdges(graph.keyMap[1]!!, graph.keyMap[5]!!, graph))

    }

}

fun main() {
    val ex = GraphEx4()
    ex.main()
}