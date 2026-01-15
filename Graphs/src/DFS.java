import java.util.ArrayList;
import java.util.Arrays;

// Algorithm: Depth-First Search
// Runtime: O(|V|+|E|)
// used to:
// - Detect Cycles in a Directed graph
// - Find the shortest path
// - Determine the connectivity in a network
// - classify the edges of the input graph


// Depth-first search explores edges out
// of the most recently discovered vertex v that still has unexplored edges leaving it.
// Once all of v’s edges have been explored, the search “backtracks” to explore edges
// leaving the vertex from which v was discovered.
// Cormen - Introduction To Algorithms

public class DFS {

    // Variable to keep track of time
    static int timer = 0;

    public static void main(String[] args){
        int[][] adjList =  {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        //  (1) - (2) - (4)
        //   |  /  |
        //  (0)   (3)

        System.out.println(dfs(adjList));
    }

    static void dfsRecord(int[][] adjList,
                            boolean[] visited,
                            int node,
                            ArrayList<Integer> result,
                            int[] visitPre,
                            int[] visitPost
                          )
    {
        visited[node] = true;
        result.add(node);

        timer++;
        visitPre[node] = timer;
        // Visited recursively all vertices
        // which are not yet visited

        //
        for (int neighbourNode : adjList[node]){
            if (!visited[neighbourNode]){
                dfsRecord(adjList, visited, neighbourNode, result, visitPre, visitPost);
            }
        }
        timer++;
        visitPost[node] = timer;
        System.out.println("Node: " + node + " | Visit: " + visitPre[node] + " | Leave: " + visitPost[node]);
    }

    static ArrayList<Integer> dfs(int[][] adjList) {
        // create the array for marking visited nodes/vertices
        boolean[] visited = new boolean[adjList.length];

        // create the array to track time of entering and leaving of the node
        int[] visitPre  = new int[adjList.length];
        int[] visitPost = new int[adjList.length];

        // create the array for storing all nodes
        ArrayList<Integer> result = new ArrayList<>();

        // iterate through all the nodes to reach disconnected components
        for (int i = 0; i < adjList.length; i++) {
            if (!visited[i])
                dfsRecord(adjList, visited, i, result, visitPre, visitPost);
        }

        return result;
    }

}
