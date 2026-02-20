package dsa.graphandtrees;
import java.util.*;

/*
    Program to perform Depth First Search (DFS)
    on a graph using recursion.
*/
class DFSGraph {

    /*
        This method performs DFS traversal
        starting from the given node.
    */
    static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {

        // Mark the current node as visited
        visited[node] = true;

        // Print the current node
        System.out.print(node + " ");

        // Traverse all adjacent nodes
        for (int neighbor : graph.get(node)) {

            // If the neighbor is not visited, call DFS recursively
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            Input format:
            vertices edges
            followed by edge list
            followed by starting node
        */

        // Input number of vertices and edges
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        // Create adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Input edges
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Input starting node
        int startNode = sc.nextInt();

        // Visited array to track visited nodes
        boolean[] visited = new boolean[vertices];

        // Call DFS method
        dfs(startNode, graph, visited);
    }
}

