package Show;

import java.util.Arrays;
import java.util.PriorityQueue;

// Algorithm: Dijkstra
// Note: Edsger W. Dijkstra (1930 – 2002) - Dutch computer scientist, mathematician, programmer.
// Runtime: O((|V|log|V| + |E|)
// usage:
// - find shortest distances from the source node to every other node in a graph


public class Dijkstra_show {
    public static void main(String[] args) {
        // Directed Graph
        int[][][] adjList = {
                {{1, 4}, {2, 8}},   // 0
                {{4, 6}, {2, 3}},   // 1
                {{3, 2}},           // 2
                {{4, 10}},          // 3
                { }
        };

//        System.out.println(Arrays.toString(dijkstra(adjList, 0)));
    }


    static int[] dijkstra(int[][][] adjList, int source) {
        int vertices = adjList.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[source] = 0;
        minHeap.offer(new int[] {0, source});

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int currentDistance = top[0];
            int currentVertex = top[1];

            if (currentDistance > distances[currentVertex])
                continue;

            for (int[] neighbour : adjList[currentVertex]) {
                int neighbourVertex = neighbour[0];
                int neighbourDistance = neighbour[1];

                if (distances[currentVertex] + neighbourDistance < distances[neighbourVertex]) {
                    distances[neighbourVertex] = distances[currentVertex] + neighbourDistance;
                    minHeap.offer(new int[] {distances[neighbourVertex], neighbourVertex});
                }
            }
        }

        return distances;
    }




}
