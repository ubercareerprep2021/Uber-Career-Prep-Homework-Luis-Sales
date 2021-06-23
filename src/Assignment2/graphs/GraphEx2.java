package Assignment2.graphs;

import java.util.HashSet;

public class GraphEx2 {

    static GraphEx1.Graph graph = new GraphEx1.Graph();
    static HashSet<GraphNode> visited = new HashSet<>();

    static void DFS(int key) {
        GraphNode currentNode = graph.keyMap.get(key);
        if (visited.contains(currentNode)) return;

        visited.add(currentNode);

        System.out.print(currentNode.data + "\t");
        for (GraphNode neighbor : graph.adjNodes.get(currentNode)) {
            DFS(neighbor.data);
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

        DFS(0);
    }

}
