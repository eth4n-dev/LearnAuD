package graph;

import graph.structures.Edge;
import java.util.*;

public class GraphTest {
    public static void main(String[] args) {
        System.out.println("====== GRAPH PRACTICE TESTS ======");

        // --- Standard Undirected Graph for BFS/DFS/Shortest Path/MST ---
        // 0 --(1)-- 1 --(1)-- 3
        // |         |       /
        // (4)      (2)    (5)
        // |         |     /
        // 2 --------+----

        Map<Integer, List<Edge>> adj = new HashMap<>();
        addEdge(adj, 0, 1, 1);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 3, 1);
        addEdge(adj, 1, 2, 2);
        addEdge(adj, 2, 3, 5);

        // Standard Tests
        testPrim(adj);
        testKruskal();
        testDijkstra(adj);
        testBFS(adj);
        testDFS(adj);

        // --- NEW TESTS (Bellman-Ford, Floyd-Warshall, Boruvka, TopoSort) ---
        testBoruvka();
        testFloydWarshall(adj);
        testBellmanFord();
    }

    private static void addEdge(Map<Integer, List<Edge>> adj, int u, int v, int w) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, w));
        adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, w));
    }

    private static void testPrim(Map<Integer, List<Edge>> adj) {
        System.out.print("Testing Prim... ");
        Prim p = new Prim();
        int res = p.getMSTCost(4, adj);
        if(res == 4) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ", Expected 4)");
    }

    private static void testKruskal() {
        System.out.print("Testing Kruskal... ");
        Kruskal k = new Kruskal();
        List<Edge> edges = new ArrayList<>();
        // Same graph as above, strictly list of edges (using the 3-arg constructor)
        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 3, 1));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(2, 3, 5));

        int res = k.getMSTCost(4, edges);

        if(res == 4) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ", Expected 4)");
    }

    private static void testDijkstra(Map<Integer, List<Edge>> adj) {
        System.out.print("Testing Dijkstra... ");
        Dijkstra d = new Dijkstra();
        int res = d.shortestPath(4, 0, 2, adj);
        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ", Expected 3)");
    }

    private static void testBFS(Map<Integer, List<Edge>> adj) {
        System.out.print("Testing BFS... ");
        BFS b = new BFS();
        List<Integer> res = b.traverse(0, adj);
        if(res.size() == 4 && res.get(0) == 0 && res.get(3) == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ")");
    }

    private static void testDFS(Map<Integer, List<Edge>> adj) {
        System.out.print("Testing DFS... ");
        DFS d = new DFS();
        List<Integer> res = d.traverse(0, adj);
        if(res.size() == 4 && res.contains(0) && res.contains(3)) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ")");
    }

    private static void testBoruvka() {
        System.out.print("Testing Boruvka... ");
        Boruvka b = new Boruvka();

        // Using the same edges as Kruskal test
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 3, 1));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(2, 3, 5));

        int res = b.getMSTCost(4, edges);
        if(res == 4) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ", Expected 4)");
    }

    private static void testFloydWarshall(Map<Integer, List<Edge>> adj) {
        System.out.print("Testing Floyd-Warshall... ");
        FloydWarshall fw = new FloydWarshall();
        int[][] dist = fw.getAllPairsShortestPaths(4, adj);

        // Check dist[0][2] (Should be 3 via path 0->1->2)
        // Check dist[0][3] (Should be 2 via path 0->1->3)
        // Check dist[0][0] (Should be 0)
        boolean pass = (dist[0][2] == 3 && dist[0][3] == 2 && dist[0][0] == 0);

        if (pass) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL (Check logic)");
        }
    }

    private static void testBellmanFord() {
        System.out.print("Testing Bellman-Ford... ");
        BellmanFord bf = new BellmanFord();

        // Create graph with Negative Edge (but no cycle)
        // 0 -> 1 (weight 4)
        // 0 -> 2 (weight 5)
        // 2 -> 1 (weight -2)  <-- The negative shortcut!
        // Shortest path 0->1 should be 0->2->1 = 5 + (-2) = 3 (better than direct 4)

        Map<Integer, List<Edge>> negGraph = new HashMap<>();
        negGraph.computeIfAbsent(0, k -> new ArrayList<>()).add(new Edge(1, 4));
        negGraph.computeIfAbsent(0, k -> new ArrayList<>()).add(new Edge(2, 5));
        negGraph.computeIfAbsent(2, k -> new ArrayList<>()).add(new Edge(1, -2));

        // Note: For Bellman-Ford, standard implementation often treats edges as directed.
        // If your implementation handles undirected, ensure you add reverse edges.
        // Here we test strictly directed behavior for clarity.

        int res = bf.shortestPath(3, 0, 1, negGraph);

        if (res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ", Expected 3)");
    }
}