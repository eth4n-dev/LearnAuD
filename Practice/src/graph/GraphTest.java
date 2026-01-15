package graph;

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

        testPrim(adj);
        testKruskal(); // Uses a fresh edge list
        testDijkstra(adj);
        testBFS(adj);
        testDFS(adj);
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
        // Same graph as above, strictly list of edges
        edges.add(new Edge(0, 1, 1)); // We assume Edge has (u, v, w) constructor or similar logic
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 3, 1));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(2, 3, 5));

        // Note: For Kruskal, we need Edge to store source (u) and dest (v).
        // Ensure your Edge class supports this or the Kruskal implementation handles it!
        // Assuming Edge class is: class Edge { int from, to, weight; ... }
        // If your Edge class only has 'to', you need a wrapper for Kruskal.

        // For this test, I'll assume you updated Edge to have 'from'
        // OR you pass a custom class. If not, Kruskal logic needs adapting.

        // Let's assume standard input for Kruskal:
        // Result should be 4 (Same as Prim)
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
}