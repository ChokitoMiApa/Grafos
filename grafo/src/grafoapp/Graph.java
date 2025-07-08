package grafoapp;

import java.util.*;

public class Graph {
    private final Map<String, Set<String>> adjList = new LinkedHashMap<>();

    public void addVertex(String v) {
        adjList.putIfAbsent(v, new LinkedHashSet<>());
    }

    public void addEdge(String v1, String v2) {
        if (adjList.containsKey(v1) && adjList.containsKey(v2)) {
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1); // grafo no dirigido
        }
    }

    public List<String> getVertices() {
        return new ArrayList<>(adjList.keySet());
    }

    public Map<String, Set<String>> getAdjList() {
        return adjList;
    }

    public int[][] getAdjacencyMatrix() {
        List<String> vertices = getVertices();
        int size = vertices.size();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String v1 = vertices.get(i);
            for (String v2 : adjList.get(v1)) {
                int j = vertices.indexOf(v2);
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }
}

