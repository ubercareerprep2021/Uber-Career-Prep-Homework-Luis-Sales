package Assignment2.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class GraphEx1 {

    public static class Graph extends GraphWithAdjacencyList {

        HashMap<Integer, GraphNode> keyMap = new HashMap<>();

        Graph() {
            adjNodes = new HashMap<>();
        }

        void addNode(int key) {
            GraphNode newNode = new GraphNode(key);
            keyMap.put(key, newNode);
            adjNodes.put(newNode, new ArrayList<>());
        }

        void removeNode(int key) {
            GraphNode nodeToRemove = keyMap.get(key);
            Stack<GraphNode> neighbors = new Stack<>();
            neighbors.addAll(adjNodes.get(nodeToRemove));

            while (!neighbors.isEmpty()) {
                removeEdge(key, neighbors.pop().data);
            }

            adjNodes.remove(nodeToRemove);
        }

        void addEdge(int node1, int node2) {
            GraphNode n1 = keyMap.get(node1);
            GraphNode n2 = keyMap.get(node2);

            adjNodes.get(n1).add(n2);
            adjNodes.get(n2).add(n1);
        }

        void removeEdge(int node1, int node2) {
            GraphNode n1 = keyMap.get(node1);
            GraphNode n2 = keyMap.get(node2);

            adjNodes.get(n1).remove(n2);
            adjNodes.get(n2).remove(n1);
        }
    }

    public static boolean areNeighbors(Graph graph, int node1, int node2) {
        return graph.adjNodes.get(graph.keyMap.get(node1)).contains(graph.keyMap.get(node2));
    }

    public static boolean nodeExists(Graph graph, int node) {
        return graph.adjNodes.get(graph.keyMap.get(node)) != null;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

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

        assert areNeighbors(graph, 0, 2);
        assert areNeighbors(graph, 0, 6);
        assert areNeighbors(graph, 6, 0);
        assert !areNeighbors(graph, 2, 6);
        assert !areNeighbors(graph, 4, 0);
        assert !areNeighbors(graph, 4, 4);

        graph.removeEdge(2, 0);
        graph.removeEdge(2, 4);
        graph.removeEdge(2, 7);

        assert !areNeighbors(graph, 0, 2);
        assert !areNeighbors(graph, 2, 0);
        assert !areNeighbors(graph, 2, 4);
        assert nodeExists(graph, 2);

        graph.removeNode(4);
        graph.removeNode(2);

        assert !nodeExists(graph,2);
        assert !nodeExists(graph,4);
        assert nodeExists(graph, 7);
    }

}
