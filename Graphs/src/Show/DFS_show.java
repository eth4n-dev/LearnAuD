package Show;

import java.util.ArrayList;

// Algorithm: Depth-First Search
// Runtime: O(|V|+|E|)
// used to:
// - Detect Cycles in a Directed graph
// - Find the shortest path
// - Determine the connectivity in a network
// - classify the edges of the input graph

public class DFS_show {

    public static void main(String[] args){
        // data structure - represents graphs.
        // stores a list of all vertices adjacent to each vertex
        int[][] adjList =  {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}, { }};
        //  (1) - (2) - (4)    (5)
        //   |  /  |
        //  (0)   (3)

        // (0)
        System.out.println(dfs(adjList));
    }

    static void dfsRecord(int[][] adjList, boolean[] visited, int node, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbourNode : adjList[node]) {
            if (!visited[neighbourNode]) {
                dfsRecord(adjList, visited, neighbourNode, result);
            }
        }
    }

    static ArrayList<Integer> dfs(int[][] adjList) {
        boolean[] visited = new boolean[adjList.length];

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < adjList.length; i++) {
            if (!visited[i])
                dfsRecord(adjList, visited, i, result);
        }

        return result;
    }


}


