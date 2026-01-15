import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// Algorithm: Dijkstra
// Runtime: O((|V|+|E|)log|V|)
// usage:
// - find shortest path distances from the source node to every other node in a graph
// - does not work with negative edge weights

public class Dijkstra {

    public static void main(String[] args) {
        // Directed Graph
        int[][][] adjList = {
                {{1, 4}, {2, 8}},   // 0
                {{4, 6}, {2, 3}},   // 1
                {{3, 2}},           // 2
                {{4, 10}},          // 3
                { }
        };

        System.out.println(Arrays.toString(dijkstra(adjList, 0)));
    }


    static int[] dijkstra(int[][][] adjList, int source) {
        int vertices = adjList.length;

        // create a min-heap data structure for pairs of (distance, node)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        // distances array stores shortest distance from source to each node
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Start from the source node
        distances[source] = 0; // distance to itself is 0
        minHeap.offer(new int[] {0, source});

        // process the queue of min-heap until all reachable vertices are worked-though
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int currentDistance = top[0];
            int currentVertex = top[1];

            // if current distance is not the shortest one, skip it
            if (currentDistance > distances[currentVertex])
                continue;

            // explore all neighbours of the current vertex
            for (int[] neighbour : adjList[currentVertex]) {
                int neighbourVertex = neighbour[0];
                int neighbourDistance = neighbour[1];

                // if there is a shorter path to neighbour through current vertex, update it
                if (distances[neighbourVertex] > distances[currentVertex] + neighbourDistance) {
                    distances[neighbourVertex] = distances[currentVertex] + neighbourDistance;
                    minHeap.offer(new int[]{distances[neighbourVertex], neighbourVertex});
                }
            }
        }

        return distances;
    }
}
