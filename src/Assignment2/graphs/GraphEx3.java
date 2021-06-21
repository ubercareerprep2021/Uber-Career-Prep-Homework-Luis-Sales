package Assignment2.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphEx3 {

    static GraphEx1.Graph graph = new GraphEx1.Graph();

    static void BFS(int key) {
        Queue<GraphNode> bfsQueue = new LinkedList<>();
        HashSet<GraphNode> visited = new HashSet<>();

        bfsQueue.add(graph.keyMap.get(key));
        visited.add(graph.keyMap.get(key));

        while (!bfsQueue.isEmpty()) {
            GraphNode current = bfsQueue.poll();

            System.out.print(current.data + "\t");

            for (GraphNode neighbor : graph.adjNodes.get(current)) {
                if (visited.contains(neighbor)) continue;
                bfsQueue.add(neighbor);
                visited.add(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        graph.addNode(0);
        graph.addNode(2);
        graph.addNode(6);
        graph.addNode(7);
        graph.addNode(4);

        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(6, 4);
        graph.addEdge(4, 7);

        BFS(0);
    }

}
