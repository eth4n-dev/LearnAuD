import java.util.ArrayList;
import java.util.Arrays;

// Algorithm: Topological Sort
// Runtime: O(|V|+|E|) (as DFS)
// usage:
// - linear ordering of vertices in the Directed Acyclic Graph (for every edge {u, v} u appears before v)

public class TopologicalSort {

    // Variable to keep track of time
    static int timer = 0;

    public static void main(String[] args){
        int[][] adjList =  {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        //  (1) - (2) - (4)
        //   |  /  |
        //  (0)   (3)

        // Get Topological Sorting of the Graph
        System.out.println(Arrays.toString(topologicalSort(adjList)));
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

        timer++;
        visitPre[node] = timer;

        // Visited recursively all vertices
        // which are not yet visited
        for (int neighbourNode : adjList[node]){
            if (!visited[neighbourNode]){
                dfsRecord(adjList, visited, neighbourNode, result, visitPre, visitPost);
            }
        }

        timer++;
        visitPost[node] = timer;

        // Note: Topological Sorting - add node to the front of a linked list once it has (recursively) visited all its neighbours
        result.add(node);

        System.out.println("Node: " + node + " | Visit: " + visitPre[node] + " | Leave: " + visitPost[node]);
    }

    static int[] topologicalSort(int[][] adjList) {
        // create the array for marking visited nodes/vertices
        boolean[] visited = new boolean[adjList.length];

        // create arrays to track time of entering and leaving of the node
        int[] visitPre  = new int[adjList.length];
        int[] visitPost = new int[adjList.length];

        // create the array for storing all nodes
        ArrayList<Integer> result = new ArrayList<>();

        // iterate through all the nodes to reach disconnected components
        for (int i = 0; i < adjList.length; i++) {
            if (!visited[i])
                dfsRecord(adjList, visited, i, result, visitPre, visitPost);
        }


        return listToArrayReversed(result);
    }

    static int[] listToArrayReversed(ArrayList<Integer> input){
        int[] output = new int[input.size()];

        for (int i = 0; i < input.size(); i++) {
            output[i] = input.get(input.size()-i-1);
        }

        return output;
    }
}
