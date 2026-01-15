package graph;

import graph.structures.*;
import java.util.*;

public class BellmanFord {

    /**
     * Goal: Return shortest distance from startNode to endNode.
     * Capable of handling negative edge weights.
     * Return Integer.MAX_VALUE (or some sentinel) if not reachable.
     * Return -1 (or throw error) if Negative Cycle detected.
     */
    public int shortestPath(int numNodes, int startNode, int endNode, Map<Integer, List<Edge>> adjList) {
        // TODO:
        // 1. Initialize dist array (startNode = 0, others = infinity)
        // 2. Relax all edges (numNodes - 1) times
        // 3. Check for negative cycles (Nth relaxation)

        return Integer.MAX_VALUE;
    }
}