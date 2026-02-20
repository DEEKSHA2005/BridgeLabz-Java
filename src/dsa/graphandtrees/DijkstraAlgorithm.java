package dsa.graphandtrees;
import java.util.*;

// Dijkstra shortest path class
class DijkstraAlgorithm {

    /*
     * This Pair class is used to store
     * a node and its distance from the source.
     */
    static class Pair {
        int node, distance;

        // Constructor to initialize node and distance
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    /*
     * This method implements Dijkstra's Algorithm
     * to find the shortest path from a source node
     * to all other nodes in the graph.
     *
     * Parameters:
     * source -> starting node
     * graph  -> adjacency list (graph representation)
     */
    static void dijkstra(int source, List<List<Pair>> graph) {

        // Number of nodes in the graph
        int n = graph.size();

        // Distance array to store shortest distance from source
        int[] dist = new int[n];

        // Initialize all distances as infinity
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance of source node is 0
        dist[source] = 0;

        /*
         * Priority Queue to always pick the node
         * with the smallest distance.
         */
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.distance - b.distance);

        // Add source node to priority queue
        pq.add(new Pair(source, 0));

        // Loop until all reachable nodes are processed
        while (!pq.isEmpty()) {

            // Get node with minimum distance
            Pair current = pq.poll();

            // Traverse all neighbors of current node
            for (Pair neighbor : graph.get(current.node)) {

                /*
                 * If a shorter path to neighbor is found,
                 * update the distance and push to queue.
                 */
                if (current.distance + neighbor.distance
                        < dist[neighbor.node]) {

                    // Update distance
                    dist[neighbor.node] =
                            current.distance + neighbor.distance;

                    // Add updated node to priority queue
                    pq.add(new Pair(neighbor.node,
                            dist[neighbor.node]));
                }
            }
        }

        // Output the shortest distances from source
        for (int i = 0; i < n; i++) {
            System.out.println(
                    "Distance from " + source + " to " + i +
                            " = " + dist[i]
            );
        }
    }
}
