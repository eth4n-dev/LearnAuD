package graph;

import java.util.*;

public class GraphTest {
    public static void main(String[] args) {
        System.out.println("====== GRAPH PRACTICE TESTS ======");

        // Setup Graph for testing
        // 0 --(1)-- 1 --(1)-- 3
        // |         |       /
        // (4)      (2)    (5)
        // |         |     /
        // 2 --------+----
        // Weights: (0-1:1), (0-2:4), (1-3:1), (1-2:2), (2-3:5)

        Map<Integer, List<Edge>> adj = new HashMap<>();
        addEdge(adj, 0, 1, 1);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 3, 1);
        addEdge(adj, 1, 2, 2);
        addEdge(adj, 2, 3, 5);

        testPrim(adj);
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
        // MST should be: 0-1(1), 1-3(1), 1-2(2) => Total 4
        int res = p.getMSTCost(4, adj);
        if(res == 4) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ", Expected 4)");
    }

    private static void testDijkstra(Map<Integer, List<Edge>> adj) {
        System.out.print("Testing Dijkstra... ");
        Dijkstra d = new Dijkstra();
        // Shortest path 0 -> 2: 0->1->2 (Cost 1+2 = 3)
        // Direct is 4, so 3 is better.
        int res = d.shortestPath(4, 0, 2, adj);
        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ", Expected 3)");
    }

    private static void testBFS(Map<Integer, List<Edge>> adj) {
        System.out.print("Testing BFS... ");
        BFS b = new BFS();
        List<Integer> res = b.traverse(0, adj);
        // BFS from 0: Should see 0, then 1, 2 (neighbors), then 3.
        // Note: Order of 1/2 depends on list order, but 3 must be last.
        if(res.size() == 4 && res.get(0) == 0 && res.get(3) == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ")");
    }

    private static void testDFS(Map<Integer, List<Edge>> adj) {
        System.out.print("Testing DFS... ");
        DFS d = new DFS();
        List<Integer> res = d.traverse(0, adj);
        // DFS is flexible, just checking we visited everyone
        if(res.size() == 4 && res.contains(0) && res.contains(3)) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Got " + res + ")");
    }
}