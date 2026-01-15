package graph;

import graph.structures.*;
import java.util.*;

public class FloydWarshall {

    /**
     * Goal: Return a 2D array [numNodes][numNodes] where dist[i][j]
     * is the shortest distance from node i to node j.
     */
    public int[][] getAllPairsShortestPaths(int numNodes, Map<Integer, List<Edge>> adjList) {
        int[][] dist = new int[numNodes][numNodes];

        // TODO:
        // 1. Initialize matrix (0 diagonal, infinity elsewhere, edge weights where they exist)
        // 2. Three nested loops: k (intermediate), i (source), j (destination)
        //    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

        return dist;
    }
}