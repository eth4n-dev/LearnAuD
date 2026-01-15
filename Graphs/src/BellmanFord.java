import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Algorithm: Bellman-Ford
// Runtime: O(|V| * |E|)
// usage:
// - find the shortest distances from a single source to all vertices in a weighted graph
// - works with negatively weighted edges but without negative cycles!
// - detect negative cycles in a graph

public class BellmanFord {

    public static void main(String[] args) throws Exception {
        int[][] edges = new int[][] {
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
        };

        int V = 5;
        int[] predecessors = new int[V];
        int source = 0;
        int target = 3;

        System.out.println(Arrays.toString(bellmanFord(V, edges, source, predecessors)));
        getShortestPathVertices(predecessors, source, target);
    }

    static void getShortestPathVertices(int[] predecessors, int source, int target) throws Exception {

        if (target >= predecessors.length) {
            throw new Exception("Target does not exist.");
        }

        int predecessor = predecessors[target];

        if (source == target){
            System.out.println(source);
            return;
        }
        else getShortestPathVertices(predecessors, source, predecessor);

        System.out.println(target);
    }


    static int[] bellmanFord(int V, int[][] edges, int source, int[] predecessors) {

        int[] dist = new int[V];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            dist[i] = INF;
        }

        dist[source] = 0;

        for (int i = 0; i < V; i++) { // Do iterations at most V-1 times
            for (int[] edge : edges) { // Iterate over all edges and relax those
                int nodeFrom = edge[0];
                int nodeTo = edge[1];
                int weight = edge[2];

                // Relaxation of edges (readjustment of shortest path
                // based on newly discovered path which lead to better (cheaper) result)
                if (dist[nodeFrom] != INF && dist[nodeTo] > dist[nodeFrom] + weight){
                    if (i == V - 1) // In case of existence of negative cycles
                        return new int[]{-1}; // just return -1 since there is no cheapest path

                    dist[nodeTo] = dist[nodeFrom] + weight;
                    predecessors[nodeTo] = nodeFrom;
                }
            }
        }
        return dist; // Return shorest distances to each node
    }

}
