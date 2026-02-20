package dsa.graphandtrees;
import java.util.*;
// Count connected components in an undirected graph
class ConnectedComponents {

    /*
     * This method counts the number of connected components
     * in a graph using Depth First Search (DFS).
     *
     * Parameters:
     * vertices -> total number of vertices in the graph
     * graph    -> adjacency list representation of the graph
     *
     * Returns:
     * count -> number of connected components
     */
    static int countComponents(int vertices, List<List<Integer>> graph) {

        // Boolean array to keep track of visited nodes
        boolean[] visited = new boolean[vertices];

        // Variable to store number of connected components
        int count = 0;

        // Loop through all vertices
        for (int i = 0; i < vertices; i++) {

            // If the vertex is not visited,
            // it means we found a new component
            if (!visited[i]) {

                // Perform DFS starting from this vertex
                DFSGraph.dfs(i, graph, visited);

                // Increment component count
                count++;
            }
        }

        // Return total number of connected components
        return count;
    }
}
