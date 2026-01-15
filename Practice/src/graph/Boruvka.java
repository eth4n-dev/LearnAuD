package graph;

import graph.structures.*;
import java.util.*;

public class Boruvka {

    /**
     * Goal: Return total MST cost using Boruvka's algorithm.
     * Logic: In each phase, find the cheapest edge leaving each component
     * and add it to MST. Repeat until only 1 component remains.
     */
    public int getMSTCost(int numNodes, List<Edge> allEdges) {
        // TODO:
        // 1. Loop until numComponents == 1
        // 2. For each component, find the minimum weight edge connecting to a different component
        // 3. Add these edges (Union-Find to merge)

        return 0;
    }
}