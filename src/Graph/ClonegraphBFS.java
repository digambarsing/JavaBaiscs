package Graph;

import java.util.*;


// Node class definition
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class ClonegraphBFS {

    // BFS-based clone function
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Clone the root node
        map.put(node, new Node(node.val));
        queue.add(node);

        // BFS traversal
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                // Add the clone of neighbor to the neighbors of the clone node
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node); // Return the cloned starting node
    }

    // Helper to print the graph (BFS)
    public void printGraph(Node node) {
        if (node == null) return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print("Node " + curr.val + " neighbors: ");
            for (Node neighbor : curr.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
            System.out.println();
        }
    }

    // Sample graph creation and testing
    public static void main(String[] args) {
        // Create original graph: 1-2-3-4-1 (cycle)
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        ClonegraphBFS graph = new ClonegraphBFS();
        System.out.println("Original Graph:");
        graph.printGraph(node1);

        Node cloned = graph.cloneGraph(node1);

        System.out.println("\nCloned Graph:");
        graph.printGraph(cloned);
    }
}
