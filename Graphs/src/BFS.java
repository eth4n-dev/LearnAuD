import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Algorithm: Breadth-First Search
// Runtime: O(|V|+|E|)
// Usage:
// - find a shortest path distance from the given node to all other nodes
// - can be also used for Topological sorting

public class BFS {

    public static void main(String[] args) {
        int[][] adjList =  {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        //  (1) - (2) - (4)
        //   |  /  |
        //  (0)   (3)

        System.out.println(bfs(adjList));
    }

    static ArrayList<Integer> bfs(int[][] adjList) {
        int vertices = adjList.length;
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> result = new ArrayList<>();

        // start with the source node
        int source = 0;
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);

        // repeat until the queue is not empty
        // Invariant (for loop): the queue consists of the set of unvisited neighbours of the currentNode
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            // add currently dequeued node to the resulting array
            result.add(currentNode);

            // check all neighbours first
            for (int neighbour : adjList[currentNode]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    // add all unvisited neighbours to the queue
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }

}