package graph;

import graph.structures.Edge;

import java.util.*;

public class DFS {
    // Goal: Return a list of nodes in the order they were visited.
    // Start from startNode.
    public List<Integer> traverse(int startNode, Map<Integer, List<Edge>> adjList) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        // TODO: Implement DFS (Iterative with Stack OR Recursive)

        return result;
    }

    // Optional helper for recursion
    private void dfsHelper(int node, Set<Integer> visited, List<Integer> result, Map<Integer, List<Edge>> adjList) {
    }
}