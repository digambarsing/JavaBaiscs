package Graph;

import java.util.ArrayList;

public class googlegraph {
    public static void main(String[] args) {
        int v=4;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);

        System.out.println("DFS Traversal of the Graph:");
        printGraph(graph, v);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];

        // Run DFS from every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }
        System.out.println();
    }

    // DFS Traversal Utility Function
    static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        // Traverse all unvisited neighbors
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}
