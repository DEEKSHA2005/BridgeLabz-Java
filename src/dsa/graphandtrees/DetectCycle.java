package dsa.graphandtrees;
import java.util.*;
// Detect cycle in an undirected graph using DFS
class DetectCycle {

    /*
     * This method checks if a cycle exists in the graph
     * using Depth First Search (DFS).
     *
     * Parameters:
     * node    -> current node being visited
     * parent -> previous node (to avoid going back)
     * graph  -> adjacency list representation of graph
     * visited-> boolean array to track visited nodes
     */
    static boolean hasCycle(int node, int parent, List<List<Integer>> graph, boolean[] visited) {

        // Mark the current node as visited
        visited[node] = true;

        // Traverse all adjacent nodes (neighbors)
        for (int neighbor : graph.get(node)) {

            // If neighbor is not visited, do DFS on it
            if (!visited[neighbor]) {

                // Recursive call
                if (hasCycle(neighbor, node, graph, visited)) {
                    return true; // Cycle found
                }

            }
            // If neighbor is visited and not the parent,
            // then a cycle exists
            else if (neighbor != parent) {
                return true; // Cycle detected
            }
        }

        // No cycle found from this path
        return false;
    }
}
